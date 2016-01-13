package qianjun.service.impl.seckill;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import qianjun.service.ISecKillPreProcessorService;
import qianjun.rdm.model.BidInfo;
import qianjun.service.impl.RequestQueue;

/**
 * Created by ZiJun
 * Description:
 * Date: 2016/1/11 :16:01.
 */
public abstract class AbstractSecKillPreProcessorService implements ISecKillPreProcessorService {
    private static final  Logger LOG = LoggerFactory.getLogger(AbstractSecKillPreProcessorService.class);
    @Autowired
    private  SecKillDB secKillDB;
    // 商品是否还有剩余 TODO 考虑放redis中，区分多个产品
    private volatile static boolean reminds = true;
    /**
     * 发送秒杀事务到数据库队列.
     */
    protected abstract void kill(BidInfo info) ;

    @Override
    public  void process(BidInfo bidInfo){
        BidInfo info = RequestQueue.queue.poll();
        if (info != null){
            kill(info);
        }
    }

    /**
     * 每一个HTTP请求都要经过该预处理.
     */
    @Override
    public  boolean preProcess(BidInfo bidInfo) {
        if (checkReminds(bidInfo.getProductCode())) {
            // 一个并发的队列
            RequestQueue.queue.add(bidInfo);
            RequestQueue.queue2.add(bidInfo);
            return true;
        } else {
            // 如果已经没有商品了，则直接驳回请求即可.
            forbidden();
            return false;
        }
    }

    private void forbidden() {
        // Do something.
        LOG.info("已经没有商品了");
    }

    private boolean checkReminds(String productCode) {
        if (reminds) {
            // 远程检测是否还有剩余，该RPC接口应由数据库服务器提供，不必完全严格检查.
            if (!secKillDB.checkReminds(productCode)) {
                reminds = false;
            }
        }
        return reminds;
    }
}
