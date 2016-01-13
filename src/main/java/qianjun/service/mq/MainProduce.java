package qianjun.service.mq;

import org.springframework.beans.factory.annotation.Autowired;
import qianjun.service.impl.seckill.SecKillDB;

/**
 * Created by ZiJun
 * Description:
 * Date: 2016/1/12 :12:39.
 */
public class MainProduce {
    public static final String clientName = "queue";
    @Autowired
    private SecKillDB secKillDB;
    public MainProduce() throws Exception{
        new Thread(){

            @Override
            public void run() {
                try {
                    RabbitMQProducer producer = new RabbitMQProducer(clientName);

                    while (true){
                        if (secKillDB.bids != null && secKillDB.bids.size() >0 ) {
                            producer.sendMessage(secKillDB.bids.poll());
                        }
//                        System.out.println("对列空");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }


    public static void process(){

        try {
            new MainProduce();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
