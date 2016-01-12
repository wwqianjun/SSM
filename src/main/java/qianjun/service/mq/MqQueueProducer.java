package qianjun.service.mq;

import org.apache.commons.lang3.SerializationUtils;

import java.io.IOException;
import java.io.Serializable;

/**
 * Created by ZiJun
 * Description:
 * Date: 2016/1/12 :11:34.
 */
public class MqQueueProducer extends AbstractConnectMq{

    public MqQueueProducer(String connectionName) throws IOException {
        super(connectionName);
    }

    public void sendMessage(Serializable object) throws IOException {
        channel.basicPublish("",connectionName, null, SerializationUtils.serialize(object));
        System.out.println(" [x] Sent '" + object + "'");
    }
}
