package com.lcydream.project.legacy;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;

/**
 * EventListenerDemo
 * 事件监听者模式
 * {@link java.util.EventObject} 标准的事件对象<br/>
 * {@link java.util.EventListener} 标准的事件监听对象<br/>
 * @author Luo Chun Yun
 * @date 2018/11/27 20:32
 */
public class EventListenerDemo {

  public static void main(String[] args) {
  	  Person person = new Person();
  	  //Java Beans 规范 -> 内省
	  //propertyChangeEvent 广播源
	  //PropertyChangeListener 注册器
	  PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(person);

    propertyChangeSupport.addPropertyChangeListener(
        "name",
        (event) -> {
          Person bean = (Person) event.getSource();
          System.out.printf("Person[%s] 的name\t新值:%s\t,老值:%s"
          ,bean,event.getNewValue(),event.getOldValue());
        });

	  //触发事件
	  propertyChangeSupport.firePropertyChange("name",
			  "luo","magic");
  }

	/**
	 * POJO Setter/Getter
	 */
	private static class Person{
  	private String name;

  	private Integer age;

	  public String getName() {
		  return name;
	  }

	  public void setName(String name) {
		  this.name = name;
	  }

	  public Integer getAge() {
		  return age;
	  }

	  public void setAge(Integer age) {
		  this.age = age;
	  }
  }
}
