package com.demo.slk.application.apachecamel.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.SingletonBeanRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class BeanFactory implements ApplicationContextAware {

    private static ApplicationContext context;

    private BeanFactory(){}

    @SuppressWarnings("unused")
	public static ApplicationContext getApplicationContext() {
    	 ConfigurableApplicationContext configContext = (ConfigurableApplicationContext)context;
    	 SingletonBeanRegistry beanRegistry = configContext.getBeanFactory();
    	//beanRegistry.registerSingleton("myBeanName", bean);
        return context;
    }

    public  static <T> T getBean(String name,Class<T> aClass){
        return context.getBean(name,aClass);
    }

    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        context = ctx;
    }
	
}
