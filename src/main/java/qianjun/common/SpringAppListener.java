package qianjun.common;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import qianjun.service.mq.MainConsumer;
import qianjun.service.mq.MainProduce;

/**
 * Created by ZiJun
 * Description:
 * Date: 2016/1/12 :18:12.
 */
public class SpringAppListener implements ApplicationListener<ContextRefreshedEvent>
{

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event)
    {
//        if(event.getApplicationContext().getParent() == null)//root application context 没有parent，他就是老大.
//        {
//            //需要执行的逻辑代码，当spring容器初始化完成后就会执行该方法。
//            System.out.println("\n\n\n\n\n______________\n\n\n加载了\n\n_________\n\n");
//        }
//
        //或者下面这种方式
        if(event.getApplicationContext().getDisplayName().equals("Root WebApplicationContext"))
        {
            MainProduce.process();
            System.out.println("生产者开启");
            MainConsumer.process();
            System.out.println("消费者开启");
        }

//        MainProduce.process();
//        System.out.println("生产者开启");
//        MainConsumer.process();
//        System.out.println("消费者开启");

    }

}
