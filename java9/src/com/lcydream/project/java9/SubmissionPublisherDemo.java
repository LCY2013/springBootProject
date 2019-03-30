package com.lcydream.project.java9;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

/**
 * SubmissionPublisherDemo
 * {@link SubmissionPublisher}
 * @author Luo Chun Yun
 * @date 2018/11/27 21:24
 */
public class SubmissionPublisherDemo {

  public static void main(String[] args) {
      try (SubmissionPublisher<Integer> publisher = new SubmissionPublisher<>()) {
	      // 订阅事件
	      publisher.subscribe(new IntegerSubscriber("L"));
	      publisher.subscribe(new IntegerSubscriber("U"));
	      publisher.subscribe(new IntegerSubscriber("O"));

	      //消费订阅的发布消息
	      CompletableFuture<Void> completableFuture = publisher.consume((consumer) -> {
		      System.out.printf("Current Thread[%s] : " +
						      "Subscriber[%s]\n",
				      Thread.currentThread().getName(),
				      consumer.intValue());
	      }).thenRunAsync/*.thenRun*/(() ->
		      System.out.printf("Current Thread[%s] RunAsync\n",
				      Thread.currentThread().getName())
	      );

	      //if(completableFuture.isDone()){
	      //
	      //}

	      // 提交数据到各个订阅器
	      publisher.submit(100);
	  }
	  /**
	   * 上面的try(){}相当于try{}finally{}
	   * try()里面的类如果实现了AutoCloseable，JVM就会自动关闭这个类
	   */
	  //关闭,这里可以用try/catch代替关闭
	  //publisher.close();
	  try {
		  Thread.currentThread().join(1000L);
	  } catch (InterruptedException e) {
		  e.printStackTrace();
	  }
  }

  private static class IntegerSubscriber
		  implements Flow.Subscriber<Integer> {

  	  private final String name;

  	  private Flow.Subscription subscription;

	  private IntegerSubscriber(String name) {
		  this.name = name;
	  }

	  @Override
	  public void onSubscribe(Flow.Subscription subscription) {
            System.out.printf("Thread[%s] : " +
		            "Current Subscriber[%s] " +
		            "subscribers : [%s]\n",
		            Thread.currentThread().getName(),
		            name,
		            subscription);
            this.subscription = subscription;
            this.subscription.request(1);
	  }

	  @Override
	  public void onNext(Integer item) {
		  System.out.printf("Thread[%s] : " +
						  "Current Subscriber[%s] " +
						  "receives item : [%d]\n",
				  Thread.currentThread().getName(),
				  name,
				  item);
		  this.subscription.request(1);
	  }

	  @Override
	  public void onError(Throwable throwable) {
        System.err.println(throwable);
	  }

	  @Override
	  public void onComplete() {
		  System.out.printf("Thread[%s] : " +
						  "Current Subscriber[%s],is complete\n",
				  Thread.currentThread().getName(),
				  name);
	  }
  }
}
