package qianjun.service.mq;

/**
 * Created by ZiJun
 * Description:
 * Date: 2016/1/12 :12:39.
 */
public class MainProduce {
    public static final String clientName = "queue";

    public MainProduce() throws Exception{
        RabbitMQProducer producer = new RabbitMQProducer(clientName);
        Thread thread  = new Thread(producer,"MainProduce");
//        thread.setDaemon(true);
        thread.start();
    }


    public static void process(){

        try {
            new MainProduce();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
