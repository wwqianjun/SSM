package qianjun.service.mq;

import org.springframework.stereotype.Component;

/**
 * Created by ZiJun
 * Description:
 * Date: 2016/1/12 :12:39.
 */
//@Component
public class MainConsumer {
    public static final String clientName = "queue";
    public MainConsumer() throws Exception{

        MqQueueConsumer consumer = new MqQueueConsumer(clientName);
        Thread consumerThread = new Thread(consumer);
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
