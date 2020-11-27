package com.learning.constructorinjectionconfig;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Resource res=new ClassPathResource("beans.xml");
        BeanFactory factory=new XmlBeanFactory(res);
        
        DemoClass dClass=(DemoClass)factory.getBean("demo");
        System.out.println(dClass.getColor());
    }
}
