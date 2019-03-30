package com.lcydream.project.iterator;

import java.util.Iterator;
import java.util.List;

/**
 * ReactorDemo
 * {@link java.util.Iterator }
 * @author Luo Chun Yun
 * @date 2018/11/28 14:46
 */
public class IteratorDemo { 

  public static void main(String[] args) {

    //数据源,java9的API
    List<Integer> values = List.of(1,2,3,4,5,6,7,8);

    //迭代
    //消费数据
    Iterator<Integer> iterator = values.iterator();

    //向服务器请求是否还有数据
    while (iterator.hasNext()){
      // 主动获取数据
      System.out.println(iterator.next());
    }
  }
}
