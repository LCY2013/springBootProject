package com.lcydream.project.springbootjmx.springbootjmx;

import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

/**
 * HelloMBeanServer
 *
 * @author Luo Chun Yun
 * @date 2018/11/25 17:29
 */
public class HelloMBeanServer {

  public static void main(String[] args) throws Exception {
	  //获取平台的管理bean
	  MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();

	  //获取ObjectName
	  ObjectName objectName = new ObjectName(
	  		"com.lcydream.project.springbootjmx.springbootjmx:type=Hello");

	  mBeanServer.registerMBean(new Hello(),objectName);

      System.out.println("jmx for HelloMBean staring ...");

	  Thread.sleep(Long.MAX_VALUE);
  }
}
