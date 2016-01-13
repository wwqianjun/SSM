package qianjun.servicetest;

import com.alibaba.fastjson.JSON;
import net.sourceforge.groboutils.junit.v1.MultiThreadedTestRunner;
import net.sourceforge.groboutils.junit.v1.TestRunnable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import qianjun.common.CommonConstants.SequenceName;
import qianjun.common.CommonException;
import qianjun.rdm.mapper.ProductOrderMapper;
import qianjun.rdm.mapper.ProductSecKillTotalMapper;
import qianjun.rdm.mapper.SequenceMapper;
import qianjun.rdm.model.BidInfo;
import qianjun.rdm.model.User;
import qianjun.rdm.util.SequenceGenerator;
import qianjun.service.IProductSecKillService;
import qianjun.service.IUserService;
import qianjun.service.impl.RequestQueue;
import qianjun.service.impl.seckill.SecKillDB;
import qianjun.service.impl.proxy.LoggerInterceptor;

import java.lang.reflect.Proxy;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml","classpath:spring-bean.xml","classpath:spring-mybatis.xml"})
public class UserServiceTest {

	private static final Logger LOG = LoggerFactory.getLogger(UserServiceTest.class);
	@Autowired
	private IUserService userService;

	@Autowired
	private SequenceMapper sequenceMapper;

	@Autowired
	private ProductOrderMapper productOrderMapper;
	@Autowired
	private ProductSecKillTotalMapper productSecKillTotalMapper;
	@Autowired
	private IProductSecKillService productSecKillService;


	@Test
	public void testDoSecKill() throws Throwable {
		TestRunnable[] trs = new TestRunnable [5];
		for(int i=0;i<5;i++){
			trs[i]=new ThreadA();
		}

		// 用于执行多线程测试用例的Runner，将前面定义的单个Runner组成的数组传入
		MultiThreadedTestRunner mttr = new MultiThreadedTestRunner(trs);

		// 开发并发执行数组里定义的内容
		mttr.runTestRunnables();

	}

	private class ThreadA extends TestRunnable {
		@Override
		public void runTest() throws Throwable {
			// 测试内容
			myCommMethod2();
		}
	}

	public void myCommMethod2() throws Exception {
		System.out.println("===" + Thread.currentThread().getId() + "begin to execute myCommMethod2");
		for (int i = 1; i <5; i++) {
			String mobile  = i*1000+"";
			BidInfo bidInfo = new BidInfo();
			bidInfo.setId(SequenceGenerator.getNextSeqWithDate12(SequenceName.PRODUCT_ORDER_ID.getValue()));
			bidInfo.setMoblie(mobile);
			bidInfo.setUserId(i);
			bidInfo.setProductCode("20160111");
			productSecKillService.doSecKill(bidInfo);
		}
		LOG.info("kill() bidsQueue={}", JSON.toJSONString(SecKillDB.bids));
		LOG.info("doSecKill(),RequestQueue={}", JSON.toJSONString(RequestQueue.queue2));
		System.out.println("===" + Thread.currentThread().getId() + "end to execute myCommMethod2");
	}
	@Test
	public void testInsertProductOrderMapper() throws Exception {
		for (int i =10; i>2; i--) {
			BidInfo bidInfo = new BidInfo();
			bidInfo.setCreateTime(new Date());
			bidInfo.setId(SequenceGenerator.getNextSeqWithDate12(SequenceName.PRODUCT_ORDER_ID.getValue()));
			bidInfo.setMoblie("22222222222");
			bidInfo.setUserId(i);
			bidInfo.setProductCode("2016011"+i%5);
			int row = productOrderMapper.insert(bidInfo);
			LOG.info("=====testInsertProductOrderMapper {} rows affected ====", row);
		}
	}

	@Test
	public void testCountProductOrderMapper() throws Exception {
		String productCode = "20160111";
		int row = productOrderMapper.countByProductCode(productCode);
		LOG.info("=====testCountProductOrderMapper productCode={}的count ={} ====",productCode,row);
	}

	@Test
	public void testproductSecKillTotalMapper(){
		String productCode = "20160111";
		int total = productSecKillTotalMapper.selectTotalByProductCode(productCode);
		LOG.info("=====testCountProductOrderMapper productCode={}total ={} ====",productCode,total);
		total = productSecKillTotalMapper.decryByProductCode(productCode);
		LOG.info("=====testCountProductOrderMapper productCode={}total ={} ====",productCode,total);
	}
	@Test
	public void testQueryUserById(){
		User user = userService.queryUserById(2);
//		System.out.println(user.getName());
		LOG.debug("用户名{}",JSON.toJSONString(user));
	}
	
	@Test
	public void testGetAllUser(){
		List<User> list = userService.getAllUser();
		LOG.info(JSON.toJSONString(list));
	}
	
	@Test
	public void getAllUserWithRole(){
		List<User> list = userService.getAllUserWithRole();
		LOG.info(JSON.toJSONString(list));
	}
	
	@Test
	public void testProxy(){
		System.out.println();
//		User user = userService.queryUserById(2);
//		System.out.println(user.getName());
//		LOG.debug("用户名{}",user.getName());
		
		//自己写的代理在Spring中运行
//		IUserService userService2 = new UserService();
		LoggerInterceptor interceptor = new LoggerInterceptor();
		interceptor.setTarget(userService);
		
		IUserService userServiceProxy = (IUserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(), new Class[]{IUserService.class}, interceptor);
		
		User user1 = userServiceProxy.queryUserById(2);
		System.out.println(user1.getName());
	}
	
	@Test
	public void add() throws CommonException{
		User user = new User();

		user.setId(Integer.parseInt( SequenceGenerator.getNextSeq(SequenceName.USER_ID.getValue()) ) );
		user.setName("杀千刀");
		user.setPassword("baizihua");
		int row = userService.addUser(user);
		
		LOG.info("{} rows affected ",row);
	}
//	
//	@Test
//	public void testGetSeqMaxValue() throws CommonException{
//		User user = new User();
//		System.out.println();
//		System.out.println();
//		String value = SequenceName.USER_ID.getValue();
//		System.out.println("getNextSeqWithDate:"+sequenceMapper.getSeqMaxValue(value));
////		System.out.println();
////		user.setId(Integer.parseInt( SequenceGenerator.getNextSeqWithDate(SequenceName.USER_ID.getValue()) ) );
////		user.setName("杀千刀");
////		user.setPassword("baizihua");
////		int row = userService.addUser(user);
////		
////		LOG.info("{} rows affected ",row);
//	}
}
