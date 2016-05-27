package com.rbs.service;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.rbs.config.ApplicationConfig;

public class ApplicationInitializer implements WebApplicationInitializer {

  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
    applicationContext.register(WebApplicationConfig.class, ApplicationConfig.class);

    Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(applicationContext));
    servlet.addMapping("/");
    servlet.setLoadOnStartup(1);

  }

}
