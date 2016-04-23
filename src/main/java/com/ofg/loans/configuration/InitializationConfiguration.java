//package com.ofg.loans.configuration;
//
//import org.springframework.web.WebApplicationInitializer;
//import org.springframework.web.context.ContextLoaderListener;
//import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
//import org.springframework.web.servlet.DispatcherServlet;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRegistration;
//
///**
// * Created by pavel on 22.04.16.
// */
//public class InitializationConfiguration implements WebApplicationInitializer {
//
//    private static final String DISPATCHER_SERVLET_NAME = "dispatcher";
//
//    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {
//        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
////        ctx.register(HibernateConfiguration.class);
//        ctx.register(SecurityConfiguration.class);
//        ctx.register(DispatcherControllerConfiguration.class);
//        servletContext.addListener(new ContextLoaderListener(ctx));
//
//        ctx.setServletContext(servletContext);
//
//        ServletRegistration.Dynamic servlet = servletContext.addServlet(DISPATCHER_SERVLET_NAME, new DispatcherServlet(ctx));
//        servlet.addMapping("/");
//        servlet.setLoadOnStartup(1);
//    }
//}