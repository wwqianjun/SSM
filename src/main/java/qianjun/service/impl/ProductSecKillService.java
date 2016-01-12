package qianjun.service.impl;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qianjun.rdm.model.BidInfo;
import qianjun.service.IProductSecKillService;
import qianjun.service.ISecKillPreProcessorService;

/**
 * Created by ZiJun
 * Description:
 * Date: 2016/1/11 :15:58.
 */
@Service("productSecKillService")
public class ProductSecKillService implements IProductSecKillService {
    private static final Logger LOG = LoggerFactory.getLogger(SecKillPreProcessorService.class);
    @Autowired
    private ISecKillPreProcessorService secKillPreProcessorService;

    @Override
    public int doSecKill(BidInfo bidInfo) {
        if (secKillPreProcessorService.preProcess(bidInfo)){
            secKillPreProcessorService.process(bidInfo);
            return 1;
        } else{
            return 0;
        }

    }
}
