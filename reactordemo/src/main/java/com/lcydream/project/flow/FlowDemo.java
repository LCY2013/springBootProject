package com.lcydream.project.flow;

import com.lcydream.project.utils.PrintUtil;

import java.util.Random;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

/**
 * FlowDemo
 *
 * @author Luo Chun Yun
 * @date 2018/11/29 13:53
 */
public class FlowDemo {

  public static void main(String[] args) {

	  try(SubmissionPublisher<String> publisher = new SubmissionPublisher<>()){
	  	    //开始订阅
            publisher.subscribe(new StringSubscriber("L"));
            publisher.subscribe(new StringSubscriber("U"));
            publisher.subscribe(new StringSubscriber("O"));

            //提交数据
		    publisher.submit("magic Luo");
      }

      //主线程休眠两秒
	  try {
		  Thread.currentThread().join(2000);
	  } catch (InterruptedException e) {
		  e.printStackTrace();
	  }
  }

  private static class StringSubscriber implements Flow.Subscriber<String>{

  	  private static final Random random = new Random();

  	  private final String name;

  	  private Flow.Subscription subscription;

	  private StringSubscriber(String name) {
		  this.name = name;
	  }

	  @Override
	  public void onSubscribe(Flow.Subscription subscription) {
		  PrintUtil.println("订阅者["+name+"],开始订阅");
		  //订阅链下移
		  subscription.request(1);
		  this.subscription = subscription;
	  }

	  @Override
	  public void onNext(String item) {
		  PrintUtil.println("订阅者["+name+"],开始消费的数据:"+item);
		  if(random.nextBoolean()){
			  this.subscription.cancel();
		  }else if(random.nextBoolean()){
		  	  throw new RuntimeException("故意异常");
		  }
	  }

	  @Override
	  public void onError(Throwable throwable) {
		  PrintUtil.println("订阅者["+name+"],出错了:"+throwable.getMessage());
	  }

	  @Override
	  public void onComplete() {
		  PrintUtil.println("订阅者["+name+"],消费完成");
	  }
  }
}
