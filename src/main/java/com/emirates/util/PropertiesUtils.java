package com.emirates.util;

import java.io.Serializable;

import javax.sql.DataSource;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

public class PropertiesUtils extends PropertyPlaceholderConfigurer implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	private static CustomProperties customProps;
	
	
//	@Override
//	public void setLocalOverride(boolean localOverride) {
//		// TODO Auto-generated method stub
//		super.setLocalOverride(true);
//	}

	
	@Autowired
	DataSource dataSource;

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		customProps = new CustomProperties(dataSource);
		setProperties(customProps);
		super.postProcessBeanFactory(beanFactory);
	}

	public static String getProperty(String name) {
		return (null == customProps.get(name)) ? "" : customProps.get(name).toString();
	}

}
