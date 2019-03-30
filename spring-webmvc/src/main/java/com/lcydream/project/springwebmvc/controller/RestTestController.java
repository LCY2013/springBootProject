package com.lcydream.project.springwebmvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * {@link RestController } = {@link org.springframework.stereotype.Controller} + {@link
 * ResponseBody} rest demo controller
 *
 * @author Luo Chun Yun
 * @date 2018/11/23 14:17
 */
@RestController
public class RestTestController {

  /**
   * // @PostMapping // Post 请求 @RequestMapping(method = RequestMethod.POST) Create(C)
   * // @GetMapping // GET 请求 @RequestMapping(method = RequestMethod.GET) Read(R) // @PutMapping //
   * Put 请求的 @RequestMapping(method = RequestMethod.PUT) Update(U) // @DeleteMapping // Post
   * 请求 @RequestMapping(method = RequestMethod.DELETE) Delete(D) // Windows 通过 PostMan 来测试 // curl
   * -X POST
   *
   * @return string
   */
  @GetMapping("/hello")
  public String index() {
    return "hello man";
  }

  @GetMapping("/npe")
  public Object createNPE() {
    throw  new NullPointerException();
  }

  @GetMapping("/404.html")
  public Object notFoundPage(HttpServletRequest request,
                             Throwable throwable){
    Map<String,Object> resultMap =
            new HashMap<>(2);
    resultMap.put("code",request.getAttribute("javax.servlet.error.status_code"));
    resultMap.put("request_uri",request.getAttribute("javax.servlet.error.request_uri"));
    return resultMap;
  }
}
