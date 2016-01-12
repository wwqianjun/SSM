package qianjun.service;

import qianjun.rdm.model.BidInfo;

/**
 * Created by ZiJun
 * Description:
 * Date: 2016/1/11 :16:30.
 */
public interface ISecKillPreProcessorService {
    /**
     * 将HTTP请求队列放入数据库队列中，参与抢购逻辑
     * @param bidInfo
     */
    public void process(BidInfo bidInfo);

    /**
     * 每一个HTTP请求都要经过该预处理,将HTTP请求放入队列中
     * @param bidInfo
     * @return false:产品已经被秒杀完
     *         true: 产品当前还可申购，但真正申购的时候可能没有
     */
    public boolean preProcess(BidInfo bidInfo);
}
