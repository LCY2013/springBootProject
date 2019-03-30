package com.lcydream.project.springbootlogback.logback;

import ch.qos.logback.classic.BasicConfigurator;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;

/**
 * LogBackDemo
 *
 * @author Luo Chun Yun
 * @date 2018/11/26 14:19
 */
public class LogBackDemo {

  public static void main(String[] args) {
  	  //-DPath=
  	  //System.setProperty("path","/user/log");
	  LoggerContext loggerContext = new LoggerContext();
	  Logger logger = loggerContext.getLogger(LogBackDemo.class);
	  //logger.addAppender(new ConsoleAppender<>());
	  BasicConfigurator basicConfigurator = new BasicConfigurator();
	  basicConfigurator.configure(loggerContext);
	  logger.info("logback info");
  }
}
