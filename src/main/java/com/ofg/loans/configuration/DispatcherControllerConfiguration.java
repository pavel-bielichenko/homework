//package com.ofg.loans.configuration;
//
//import org.springframework.context.annotation.*;
//import org.springframework.web.servlet.ViewResolver;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;
//import org.springframework.web.servlet.view.JstlView;
//
///**
// * Created by pavel on 19.04.16.
// */
//@Configuration
//@EnableWebMvc
//@PropertySource(value = {"classpath:application.properties"})
//@ComponentScan({"com.ofg.loans.dao", "com.ofg.loans.risk", "com.ofg.loans.services", "com.ofg.loans.controllers"})
////@Import(HibernateConfiguration.class)
//public class DispatcherControllerConfiguration extends WebMvcConfigurerAdapter {
//
//    @Bean(name="viewResolver")
//    public ViewResolver viewResolver() {
//        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//        viewResolver.setViewClass(JstlView.class);
//        viewResolver.setPrefix("/WEB-INF/views/");
//        viewResolver.setSuffix(".jsp");
//        return viewResolver;
//    }
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
//    }
//
//}
