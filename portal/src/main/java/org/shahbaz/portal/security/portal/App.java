package org.shahbaz.portal.security.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
@EnableAutoConfiguration
public class App
{
    public static void main( String[] args )
    {

        SpringApplication.run( new Class[] { App.class },
                               args );

    }
}