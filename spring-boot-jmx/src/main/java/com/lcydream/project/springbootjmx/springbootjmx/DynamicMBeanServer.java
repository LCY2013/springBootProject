package com.lcydream.project.springbootjmx.springbootjmx;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.StandardMBean;
import java.lang.management.ManagementFactory;

/**
 * DynamicMBeanServer
 *
 * @author Luo Chun Yun
 * @date 2018/11/25 19:58
 */
public class DynamicMBeanServer {

  public static void main(String[] args) throws Exception{
	  //获取平台的管理bean
	  MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();

	  //获取ObjectName
	  ObjectName objectName = new ObjectName(
			  "com.lcydream.project.springbootjmx.springbootjmx:type=Data");

	  Data data = new DataManagedBean();

	  StandardMBean standardMBean = new StandardMBean(data, Data.class);

	  mBeanServer.registerMBean(standardMBean,objectName);

	  System.out.println("jmx for DynamicMBeanServer staring ...");

	  Thread.sleep(Long.MAX_VALUE);
  }
}
