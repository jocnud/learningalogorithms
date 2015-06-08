package org.shahbaz.portal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan( basePackages = { "org.shahbaz.*" } )
public class MvcConfig extends WebMvcConfigurerAdapter
{

    @Override
    public void addResourceHandlers( ResourceHandlerRegistry registry )
    {
        registry.addResourceHandler( "/resources/**" ).addResourceLocations( "/resources/" );
    }

    @Bean
    public ViewResolver getViewResolver()
    {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix( "/WEB-INF/views/" );
        resolver.setSuffix( ".jsp" );
        return resolver;
    }

    @Bean( name = "messageSource" )
    public ReloadableResourceBundleMessageSource getMessageSource()
    {
        ReloadableResourceBundleMessageSource resource = new ReloadableResourceBundleMessageSource();
        resource.setBasename( "classpath:messages" );
        resource.setDefaultEncoding( "UTF-8" );
        return resource;
    }

}
