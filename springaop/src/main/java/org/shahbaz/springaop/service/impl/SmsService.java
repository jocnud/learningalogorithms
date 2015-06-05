package org.shahbaz.springaop.service.impl;

import org.shahbaz.springaop.service.MessageService;

public class SmsService implements MessageService {

	public void sendMessage(String message) {
		System.out.println("Sending an sms");

	}

	public void sendMessageWithImage(String message, String imagePath) {
		System.out.println("Sending an sms with image");

	}

	public String reciveMessage() {
		return "Hell SMS !";
	}

	public void sendMessageWithAccessToken(String message, String token) {
		// TODO Auto-generated method stub

	}

}
