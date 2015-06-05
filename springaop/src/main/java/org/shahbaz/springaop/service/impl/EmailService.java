package org.shahbaz.springaop.service.impl;

import org.shahbaz.springaop.service.MessageService;

public class EmailService implements MessageService {

	public void sendMessage(String message) {
		System.out.println("Sending Message via email");
	}

	public void sendMessageWithImage(String message, String imagePath) {
		System.out.println("Sending message with attached image");
	}

	public String reciveMessage() {
		return "Hello Email !";

	}

	public void sendMessageWithAccessToken(String message, String token) {
		// TODO Auto-generated method stub

	}

}
