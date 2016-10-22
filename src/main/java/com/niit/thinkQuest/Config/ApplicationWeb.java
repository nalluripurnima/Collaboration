package com.niit.thinkQuest.Config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ApplicationWeb extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{ApplicationContextConfig.class,applicationDispatcher.class,applicationmvc.class};
	}
	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		return null;
	}
	@Override
	protected String[] getServletMappings() {
		return  new String[]{"/"};
	}

}
