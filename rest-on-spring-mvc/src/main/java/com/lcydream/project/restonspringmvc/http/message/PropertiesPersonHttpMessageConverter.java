package com.lcydream.project.restonspringmvc.http.message;

import com.lcydream.project.restonspringmvc.entity.Person;
import com.lcydream.project.restonspringmvc.http.media.CustomMediaType;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Properties;
import java.util.PropertyResourceBundle;

/**
 * PropertiesPersonHttpMessageConverter
 * Person 自描述消息定义
 * @author Luo Chun Yun
 * @date 2018/11/22 13:56
 */
public class PropertiesPersonHttpMessageConverter
        extends AbstractHttpMessageConverter<Person> {

    /**
     * 重新实现自定义自描述消息的构造方法
     */
    public PropertiesPersonHttpMessageConverter() {
        super(MediaType.valueOf(CustomMediaType.
                APPLICATION_ATOM_PERSON_PROPERTIES_VALUE));
        setDefaultCharset(Charset.forName("UTF-8"));
    }

    /**
     * 查看是否是支持转换的的类型,这里定义的是Person的子类
     * @param clazz 需要转换的类型
     * @return 返回是否
     */
    @Override
    protected boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(Person.class);
    }

    /**
     * 读协议解析
     * 讲请求内容中 Properties 内容转化成 Person 对象
     * @param clazz 解析的类型
     * @param inputMessage 读入的信息
     * @return 返回person对象
     * @throws IOException 异常
     * @throws HttpMessageNotReadableException  异常
     */
    @Override
    protected Person readInternal(Class<? extends Person> clazz,
                                  HttpInputMessage inputMessage)
            throws IOException, HttpMessageNotReadableException {
        //读入数据流
        InputStream inputStream = inputMessage.getBody();
        //创建properties对象接受数据流
        Properties properties = new Properties();
        //加载流对象
        properties.load(inputStream);
        //将properties中的信息加载到person对象中
        Person person = new Person();
        if(StringUtils.isEmpty(properties.getProperty("person.id"))
            || StringUtils.isEmpty(properties.getProperty("person.name"))){
            return null;
        }
        person.setId(Integer.valueOf(properties.getProperty("person.id")));
        person.setName(properties.getProperty("person.name"));
        return person;
    }

    /**
     * 写信息
     * 响应PropertiesPerson的自描述信息
     * @param person 对象类
     * @param outputMessage 输出信息
     * @throws IOException 异常
     * @throws HttpMessageNotWritableException 异常
     */
    @Override
    protected void writeInternal(Person person,
                                 HttpOutputMessage outputMessage)
            throws IOException, HttpMessageNotWritableException {
        //获取输出信息对象
        OutputStream outputStream = outputMessage.getBody();
        //构建一个properties对象
        Properties properties = new Properties();
        properties.setProperty("person.id",String.valueOf(person.getId()));
        properties.setProperty("person.name",person.getName());
        //写出信息
        properties.store(new OutputStreamWriter(outputStream),"write by rest mvc");
    }
}
