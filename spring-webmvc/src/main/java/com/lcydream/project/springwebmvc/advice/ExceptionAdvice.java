package com.lcydream.project.springwebmvc.advice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * ExceptionAdvice
 * SpringMVC中的异常处理拦截
 * {@link RestControllerAdvice} 代表 {@link ResponseBody} +
 *      {@link org.springframework.web.bind.annotation.ControllerAdvice}
 * {@link RestControllerAdvice 这里不指定value就会扫描当前的目录}
 * @author Luo Chun Yun
 * @date 2018/11/23 16:44
 */
@RestControllerAdvice(basePackages = {"com.lcydream.project.springwebmvc.controller"})
public class ExceptionAdvice  {


    /**
     * SpringMvc处理异常模式
     * @param throwable AOP注入异常信息
     * @return 返回响应码
     */
    @ExceptionHandler(value = {NullPointerException.class,
                        IllegalAccessException.class,
                        IllegalStateException.class})
    public Object happenNPE(Throwable throwable){
        Map<String,Object> resultMap =
                new HashMap<>(2);
        resultMap.put("message",throwable+"");
        resultMap.put("code","500");
        return resultMap;
    }
}
