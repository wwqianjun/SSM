package qianjun.service;

import qianjun.rdm.model.BidInfo;

/**
 * Created by ZiJun
 * Description:
 * 产品秒杀相关的对外服务接口
 * Date: 2016/1/11 :15:53.
 */
public interface IProductSecKillService {

    int doSecKill(BidInfo bidInfo);
}
