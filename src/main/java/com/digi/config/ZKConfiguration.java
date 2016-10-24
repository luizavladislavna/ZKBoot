package com.digi.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.zkoss.zk.au.http.DHtmlUpdateServlet;
import org.zkoss.zk.ui.http.DHtmlLayoutServlet;
import org.zkoss.zk.ui.http.HttpSessionListener;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tymoshenkol on 24-Oct-16.
 */
@Configuration
class ZKConfiguration {

	@Bean
	public ServletRegistrationBean dHtmlLayoutServlet() {
		Map<String, String> params = new HashMap<>();
		params.put("update-uri", "/zkau");
		DHtmlLayoutServlet dHtmlLayoutServlet = new DHtmlLayoutServlet();
		ServletRegistrationBean reg = new ServletRegistrationBean(dHtmlLayoutServlet, "*.zul");
		reg.setLoadOnStartup(1);
		reg.setInitParameters(params);
		return reg;
	}

	@Bean
	public ServletRegistrationBean dHtmlUpdateServlet() {
		Map<String, String> params = new HashMap<>();
		params.put("update-uri", "/zkau/*");
		ServletRegistrationBean reg = new ServletRegistrationBean(new DHtmlUpdateServlet(), "/zkau/*");
		reg.setLoadOnStartup(2);
		reg.setInitParameters(params);
		return reg;
	}

	@Bean
	public HttpSessionListener httpSessionListener() {
		return new HttpSessionListener();
	}

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".zul");
		return viewResolver;
	}

}
