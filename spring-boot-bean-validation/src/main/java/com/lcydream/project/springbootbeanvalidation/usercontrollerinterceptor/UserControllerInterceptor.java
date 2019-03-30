package com.lcydream.project.springbootbeanvalidation.usercontrollerinterceptor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * UserControllerInterceptor
 *
 * @author Luo Chun Yun
 * @email 1475653689@qq.com
 * @date 2018/12/2 14:05
 */
@Component
public class UserControllerInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request,
	                         HttpServletResponse response,
	                         Object handler) throws Exception {
		//校验逻辑存在在这里

		return true;
	}

	/**
	 * 这里可以做后置处理，包括修改http的状态码
	 * @param request
	 * @param response
	 * @param handler
	 * @param modelAndView
	 * @throws Exception
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

		//获取状态码
		int status = response.getStatus();

		//将400的状态码转为200
		if(status == HttpStatus.BAD_REQUEST.value()){
			response.setStatus(HttpStatus.OK.value());
		}
	}
}
