package com.lcydream.project.legacy;

import java.util.Observable;

/**
 * ObserverDemo
 * 观察者模式Demo
 * @author Luo Chun Yun
 * @date 2018/11/27 17:14
 */
public class ObserverDemo {

  public static void main(String[] args) {

  	  //第一个缺点：Vector作为底层存储(全线程安全的)
	  //第二个缺点：没有支持泛型
	  //第三个缺点：同步    ->   阻塞
	  MyObserver observer = new MyObserver();

	  //第一个观察者
	  observer.addObserver(
        (observable, value) ->
          System.out.printf("observable one listen : %s\n",value));

	  //第二个观察者
	  observer.addObserver(
			  (observable, value) ->
					  System.out.printf("observable two listen : %s\n",value));

	  //设置观察者选项
	  observer.setChanged();

	  observer.notifyObservers("magic");

  }

}
class MyObserver extends Observable{

	@Override
	protected synchronized void setChanged() {
		super.setChanged();
	}
}


