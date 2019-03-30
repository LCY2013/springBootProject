package com.lcydream.project.restonspringmvc.comtroller;

import com.alibaba.fastjson.JSON;
import com.lcydream.project.restonspringmvc.entity.Person;
import com.lcydream.project.restonspringmvc.http.media.CustomMediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * PersonController
 * use restful configuration{@link RestController}
 * @author Luo Chun Yun
 * @date 2018/11/20 16:56
 */
@RestController
public class PersonController {

    @GetMapping("/getPerson/{id}")
    public Person getPerson(@PathVariable int id,
                            @RequestParam(required = false) String name){
        Person person = new Person();
        person.setId(id);
        person.setName(name);
        return person;
    }

    /**
     * json到properties转换
     * @param json json字符串
     * @return 返回类型
     */
    @PostMapping(value = "/json/properties",
                consumes = {CustomMediaType.TEXT_PLAIN_VALUE}, //请求类型
                produces = CustomMediaType.APPLICATION_ATOM_PERSON_PROPERTIES_VALUE //响应类型
                )
    public Person personPropertiesToJson(@RequestBody String json){
        Person person = new Person();
        try{
            //解析JSON格式的字符串
            Map<String,Object> personMap = JSON.parseObject(json);
            //获取JSON中的参数信息
            person.setId(Integer.valueOf(personMap.get("id")+""));
            person.setName(personMap.get("name")+"");
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return person;
    }

    @PostMapping(value = "/json/properties",
            produces = {CustomMediaType.APPLICATION_ATOM_PERSON_PROPERTIES_VALUE} // 响应类型
    )
    public Person personJsonToProperties(@RequestBody Person person) {
        // @RequestBody 的内容是 JSON
        // 响应的内容是 Properties
        return person;
    }


    @PostMapping(value = "/properties/json",
                consumes = {CustomMediaType.APPLICATION_ATOM_PERSON_PROPERTIES_VALUE},
                produces = CustomMediaType.APPLICATION_JSON_UTF8_VALUE)
    public Person personPropertiesToJson(@RequestBody Person person){
        // @RequestBody 的内容是 Properties
        // 响应的内容是 JSON
        return person;
    }
}
