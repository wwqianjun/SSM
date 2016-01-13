package qianjun.service.impl.seckill;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import qianjun.rdm.model.BidInfo;

/**
 * Created by ZiJun
 * Description:
 * Date: 2016/1/11 :16:32.
 */
@Service("secKillPreProcessorService")
public class SecKillPreProcessorService extends AbstractSecKillPreProcessorService {

    private static final Logger LOG = LoggerFactory.getLogger(SecKillPreProcessorService.class);
    @Override
    protected void kill(BidInfo info) {
        if (SecKillDB.bids.size() <=10) {
            SecKillDB.bids.add(info);
        }

    }
}
