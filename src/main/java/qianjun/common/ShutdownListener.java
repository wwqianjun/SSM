package qianjun.common;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Function: <br>
 * 监听web容器的关闭事件,释放资源，关闭未正常退出的线程<br>
 * <!--默认关闭 Hashed wheel timer线程,要关闭其他线程可以参考以下配置--> <br>
 * 在web.xml这样配置: <br>
 *     <!--1,启动参数-->
 * <context-param> <br>
 * <param-name>interrupt_thread_names</param-name><br>
 * <param-value>xx,yy,zz</param-value> <br>
 * </context-param> <br>
 *     <!--2,Servlet 监听-->
 * <listener> <br>
 * <listener-class>qianjun.common.ShutdownListener</listener-class> <br>
 * </listener>
 * 
 * @date: 2016年1月7日
 * 
 */
public class ShutdownListener implements ServletContextListener {
    
    private static final Logger LOG = LoggerFactory.getLogger(ShutdownListener.class);
    
    /** 默认关闭Netty的HashedWillTimer */
    private static final String NETTY_TIMER_THREAD = "Hashed wheel timer";
    
    /** web.xml要interrupt的线程参数名,多个值以逗号分隔 */
    private static final String cfg_name = "RabbitMQ_THREAD_NAME";
    
    /** interrupt线程名称，方便后续扩展 */
    private static List<String> threadNames = new ArrayList<String>();
    
    @Override
    public void contextDestroyed(ServletContextEvent ctx) {
        for (Thread thread : Thread.getAllStackTraces().keySet()) {

            if (threadNames.contains(thread.getName())) {
                thread.interrupt();
                LOG.info("interrupt thread:{}", thread);
            }else {
                LOG.info("=========currentThreadNames: {} != 指定的name:{}========",thread.getName(),threadNames);
            }
        }
    }
    
    @Override
    public void contextInitialized(ServletContextEvent ctxEvent) {
        // 如果在web.xml配置了参数(多个参数必须以逗号分隔),则将参数add到list
        String nameStr = ctxEvent.getServletContext().getInitParameter(cfg_name);

        if (nameStr != null && nameStr.length() > 0) {
            String[] names = nameStr.split(",");
            for (String name : names) {
                threadNames.add(name);
            }
        }
//        threadNames.add(NETTY_TIMER_THREAD);
        LOG.info("interrupt_thread_names:{}", threadNames);
    }
}
