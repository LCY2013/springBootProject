package com.lcydream.project.springbootlogback.sl4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Sl4jDemo
 *
 * @author Luo Chun Yun
 * @date 2018/11/26 16:40
 */
public class Sl4jDemo {

  public static void main(String[] args) {
	  Logger logger = LoggerFactory.getLogger(Sl4jDemo.class);
	  logger.info("info i");
  }
}
