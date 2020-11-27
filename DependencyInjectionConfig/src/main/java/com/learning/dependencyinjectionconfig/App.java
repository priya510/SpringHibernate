package com.learning.dependencyinjectionconfig;

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
        
        DemoClass d=new DemoClass();
        //d.show();
        
        DemoClass d2=new DemoClass();
        d2.disp();
        
//        DemoClass dClass=(DemoClass)factory.getBean("demo");
//        dClass.show();
        
        DemoClass dClass2=(DemoClass)factory.getBean("demo2");
        dClass2.disp();
    }
}
