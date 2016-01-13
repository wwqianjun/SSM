package qianjun.service.impl.seckill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import qianjun.rdm.mapper.ProductOrderMapper;
import qianjun.rdm.mapper.ProductSecKillTotalMapper;
import qianjun.rdm.model.BidInfo;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by ZiJun
 * Description:
 * Date: 2016/1/11 :16:43.
 */
@Service("secKillDB")
public class SecKillDB {

    @Autowired
    private ProductSecKillTotalMapper productSecKillTotalMapper;

    @Autowired
    private ProductOrderMapper productOrderMapper;

    public static boolean reminds = true;
    public static boolean localReminds = true;
    public static int count = 10;
    public static ArrayBlockingQueue<BidInfo> bids = new ArrayBlockingQueue<BidInfo>(10);

    public boolean checkReminds(String productCode) {
        if (reminds){
            int total = productSecKillTotalMapper.selectTotalByProductCode(productCode);
            if (total <= 0){
                reminds = false;
            }
            productSecKillTotalMapper.decryByProductCode(productCode);
        }
        return reminds;
    }

    // 单线程操作
    public boolean bid( BidInfo info) {

        if (localReminds) {
            // insert into table Bids values(item_id, user_id, bid_date, other)
            productOrderMapper.insert(info);

            System.out.println("Message received" + info + " success buy!");

            // select count(id) from Bids where item_id = ?
            // 如果数据库商品数量大约总数，则标志秒杀已完成，设置标志位reminds = false.
            int produceCount = productOrderMapper.countByProductCode(info.getProductCode());
            if (produceCount >= count ){
                localReminds = false;
                reminds = false;
                System.out.println("Message received" + info + " failure buy!");
            }
        }else{
            localReminds = false;
            reminds = false;
            System.out.println("Message received" + info + " failure buy!");
        }
        return localReminds;
//        BidInfo info = bids.poll();
//        while (count-- > 0 && info != null) {
//            // insert into table Bids values(item_id, user_id, bid_date, other)
//            productOrderMapper.insert(info);
//            // select count(id) from Bids where item_id = ?
//            // 如果数据库商品数量大约总数，则标志秒杀已完成，设置标志位reminds = false.
//            int produceCount = productOrderMapper.countByProductCode(info.getProductCode());
//            if (produceCount >= count ){
//                reminds = false;
//                return;
//            }
//            info = bids.poll();
//        }
    }
}
