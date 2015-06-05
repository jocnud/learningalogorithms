package org.shahbaz.springaop.demo;

import org.shahbaz.springaop.config.ApplicationConfig;
import org.shahbaz.springaop.service.MessageService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Demo application for Spring AOP
 * 
 * @author Shahbaz.Khan
 *
 */

public class App {
	public static void main(String[] args) {

		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
		appContext.register(ApplicationConfig.class);
		appContext.refresh();

		MessageService messageService = appContext
				.getBean(MessageService.class);
		/*
		 * messageService.sendMessageWithAccessToken("Hellow there !",
		 * "QKJEKHDSD8839SDKJDJ2ss99213KDJ");
		 */
		System.out.println(messageService.reciveMessage());

	}
}
