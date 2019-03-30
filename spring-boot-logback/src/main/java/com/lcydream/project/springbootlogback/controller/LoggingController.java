package com.lcydream.project.springbootlogback.controller;

import ch.qos.logback.classic.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * LoggingController
 *
 * @author Luo Chun Yun
 * @date 2018/11/26 16:50
 */
@Controller
public class LoggingController extends BaseController{

	//private Logger logger = LoggerFactory.getLogger(LoggingController.class);

	@GetMapping("/logging")
	@ResponseBody
	public void logging(@RequestParam(required = false) String message){
		if(logger instanceof ch.qos.logback.classic.Logger){
			ch.qos.logback.classic.Logger.class.cast(logger).setLevel(Level.DEBUG);
		}
		logger.info(message);
	}
}
