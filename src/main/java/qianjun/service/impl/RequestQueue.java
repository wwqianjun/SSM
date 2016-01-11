package qianjun.service.impl;

import qianjun.rdm.model.BidInfo;

import java.util.concurrent.ConcurrentLinkedQueue;

public class RequestQueue {
	public static ConcurrentLinkedQueue<BidInfo> queue = new ConcurrentLinkedQueue();
	public static ConcurrentLinkedQueue<BidInfo> queue2 = new ConcurrentLinkedQueue();
}
