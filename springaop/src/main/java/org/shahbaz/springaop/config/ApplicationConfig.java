package org.shahbaz.springaop.config;

import org.shahbaz.springaop.aspects.LoggingAspect;
import org.shahbaz.springaop.aspects.MessageServiceAspect;
import org.shahbaz.springaop.service.MessageService;
import org.shahbaz.springaop.service.impl.EmailService;
import org.shahbaz.springaop.service.impl.SmsService;
import org.shahbaz.springaop.service.impl.TwitterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * This is Configuration class used to inject all the beans. Node Aspects are
 * also injected from here
 * 
 * @author Shahbaz.Khan
 *
 */
@Configuration
@ComponentScan(value = "org.shahbaz.springaop.service.*")
@EnableAspectJAutoProxy
public class ApplicationConfig {

	@Bean
	public MessageService getMessageService() {
		return new SmsService();
	}

	@Bean
	public LoggingAspect getLoggingAspect() {
		return new LoggingAspect();
	}

	@Bean
	public MessageServiceAspect getMessageServiceAspect() {
		return new MessageServiceAspect();
	}

}
