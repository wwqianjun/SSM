package qianjun.service.mq;

import org.apache.commons.lang3.SerializationUtils;
import qianjun.common.SpringAppContext;
import qianjun.service.impl.seckill.SecKillDB;

import java.io.IOException;
import java.io.Serializable;

/**
 * Created by ZiJun
 * Description:
 *  RabbitMQ 生产者client
 * Date: 2016/1/12 :11:34.
 */
public class RabbitMQProducer extends AbstractConnectMq implements Runnable{

    private SecKillDB secKillDB = (SecKillDB) SpringAppContext.getBean("secKillDB");

    public RabbitMQProducer(String connectionName) throws IOException {
        super(connectionName);
    }

    /**
     * 发送消息
     * @param object 序列化过的消息体
     * @throws IOException
     */
    public void sendMessage(Serializable object) throws IOException {
        channel.basicPublish("",connectionName, null, SerializationUtils.serialize(object));
        System.out.println(" [x] Sent '" + object + "'");
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()){
                if (secKillDB.bids != null && secKillDB.bids.size() >0 ) {
                    sendMessage(secKillDB.bids.poll());
                }
            }
            System.out.println("=====MainProduce exit!======");
            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
