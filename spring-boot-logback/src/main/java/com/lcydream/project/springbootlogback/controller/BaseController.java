package com.lcydream.project.springbootlogback.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

/**
 * BaseController
 *
 * @author Luo Chun Yun
 * @date 2018/11/26 21:45
 */
@Controller
public class BaseController {

	protected Logger logger = LoggerFactory.getLogger(LoggingController.class);
}
