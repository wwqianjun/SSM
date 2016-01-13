package qianjun.service.mq;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;
import org.apache.commons.lang3.SerializationUtils;
import qianjun.common.SpringAppContext;
import qianjun.rdm.model.BidInfo;
import qianjun.service.impl.seckill.SecKillDB;

import java.io.IOException;

/**
 * Created by ZiJun
 * Description:
 * Date: 2016/1/12 :11:54.
 */

public class RabbitMQConsumer extends AbstractConnectMq implements Runnable,Consumer {

    /**
     * 注解spring bean
     */
//    @Autowired
//    private SecKillDB secKillDB;
    private  SecKillDB secKillDB = (SecKillDB)SpringAppContext.getBean("secKillDB");

    public RabbitMQConsumer(String connectionName) throws IOException {
        super(connectionName);
    }

    /**
     * Called when consumer is registered.
     */
    @Override
    public void handleConsumeOk(String consumerTag) {
        System.out.println("Consumer "+consumerTag +" registered");
    }

    @Override
    public void handleCancelOk(String s) {
        System.out.println("handleCancelOk "+s +" CancelOk");
    }

    @Override
    public void handleCancel(String s) throws IOException {
        System.out.println("handleCancel "+s +" Cancel");
    }

    @Override
    public void handleShutdownSignal(String s, ShutdownSignalException e) {
        System.out.println("handleShutdownSignal "+s +" Shutdown");
    }

    @Override
    public void handleRecoverOk(String s) {
        System.out.println("handleRecoverOk "+s +" Recover");
    }

    /**
     * Called when new message is available.
     */
    @Override
    public void handleDelivery(String s, Envelope envelope, BasicProperties basicProperties, byte[] body) throws IOException {
        BidInfo bidInfo = (BidInfo)SerializationUtils.deserialize(body);
        System.out.println("Message Number "+ bidInfo + " received.");
        if (secKillDB == null){
            System.out.println("Message secKillDB null!");
        }
        else if (secKillDB.bid(bidInfo)){
            System.out.println("Message success consumer!");
        }else{
            System.out.println("Message success consumer! but no buy success!");
        }
    }

    @Override
    public void run() {
        try {
            //start consuming messages. Auto acknowledge messages.
            channel.basicConsume(connectionName, true,this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
