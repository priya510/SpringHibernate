package com.learning.hibernatedemo.service;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.learning.hibernatedemo.models.SampleModel;

public class HibernateUtil {

	public static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory()
	{
		if(sessionFactory==null)
		{
			Properties properties=new Properties();
			//connection properties
			properties.setProperty("hibernate.connection.driver_class","org.h2.Driver");
			properties.setProperty("hibernate.connection.url","jdbc:h2:tcp://localhost/~/hiberdb");
			properties.setProperty("hibernate.connection.username","sa");
			properties.setProperty("hibernate.connection.password","");
			
			
			//hibernate properties
			properties.setProperty("hibernate.dialect","org.hibernate.dialect.H2Dialect");
			properties.setProperty("hibernate.current_session_context_class","thread");
			properties.setProperty("hibernate.hbm2ddl.auto","update");
			properties.setProperty("hibernate.show_sql","true");
			properties.setProperty("hibernate.format_sql","true");
			
			Configuration config=new Configuration();
			config.addAnnotatedClass(SampleModel.class);
			
			ServiceRegistry registry=new StandardServiceRegistryBuilder()
									.applySettings(properties)
									.build();

				sessionFactory=config.buildSessionFactory(registry);
				System.out.println(sessionFactory);

			
		}
		
		return sessionFactory;
	}
	
}
