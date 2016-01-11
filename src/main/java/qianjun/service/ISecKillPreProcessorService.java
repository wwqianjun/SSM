package qianjun.service;

import qianjun.rdm.model.BidInfo;

/**
 * Created by ZiJun
 * Description:
 * Date: 2016/1/11 :16:30.
 */
public interface ISecKillPreProcessorService {
    public void process(BidInfo bidInfo);

    public boolean preProcess(BidInfo bidInfo);
}
