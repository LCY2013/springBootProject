package com.lcydream.project.spring;

import com.lcydream.project.utils.PrintUtil;
import org.springframework.core.task.AsyncListenableTaskExecutor;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * ListenableFutureDemo {@link org.springframework.util.concurrent.ListenableFuture}
 *
 * @author Luo Chun Yun
 * @date 2018/11/28 15:17
 */
public class ListenableFutureDemo {

  public static void main(String[] args) {

    AsyncListenableTaskExecutor simpleAsyncTaskExecutor =
        new SimpleAsyncTaskExecutor("ListenableFutureDemo-");

    // ListenableFuture future实例
    ListenableFuture<Integer> future = simpleAsyncTaskExecutor
		    .submitListenable(() -> 10);

    // 添加callback
    future.addCallback(
        new ListenableFutureCallback<>() {
          @Override
          public void onFailure(Throwable ex) {
            PrintUtil.println(ex.getMessage());
          }

          @Override
          public void onSuccess(Integer result) {
            PrintUtil.println(result);
          }
        });

	  future = simpleAsyncTaskExecutor
			  .submitListenable(() -> 20);

	  // 添加callback
	  future.addCallback(
			  new ListenableFutureCallback<>() {
				  @Override
				  public void onFailure(Throwable ex) {
					  PrintUtil.println(ex.getMessage());
				  }

				  @Override
				  public void onSuccess(Integer result) {
					  PrintUtil.println(result);
				  }
			  });


	  try {
	  	  //阻塞知道结果集出来
		  future.get();
	  } catch (InterruptedException e) {
		  e.printStackTrace();
	  } catch (ExecutionException e) {
		  e.printStackTrace();
	  }
  }
}
