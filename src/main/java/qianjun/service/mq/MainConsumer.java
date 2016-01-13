package qianjun.service.mq;

/**
 * Created by ZiJun
 * Description:
 * Date: 2016/1/12 :12:39.
 */
//@Component
public class MainConsumer {
    public static final String clientName = "queue";
    public MainConsumer() throws Exception{

        RabbitMQConsumer consumer = new RabbitMQConsumer(clientName);
        Thread consumerThread = new Thread(consumer);
        consumerThread.setName("MainConsumer");
//        consumerThread.setDaemon(true);
        consumerThread.start();
    }


    public static void process() {
        try {
            new MainConsumer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
