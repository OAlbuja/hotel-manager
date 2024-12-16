package com.hotel.soap.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;

import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.XsdSchema;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.core.io.ClassPathResource;


@EnableWs
@Configuration
public class WebServiceConfig {
    
    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext context) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(context);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean(name = "availability")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema availabilitySchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("AvailabilityPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://hotel.com/availability");
        wsdl11Definition.setSchema(availabilitySchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema availabilitySchema() {
        System.out.println("Attempting to load availability.xsd...");
        return new SimpleXsdSchema(new ClassPathResource("availability.xsd", getClass().getClassLoader()));
    }

}
