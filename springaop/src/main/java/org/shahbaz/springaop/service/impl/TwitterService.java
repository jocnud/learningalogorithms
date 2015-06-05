package org.shahbaz.springaop.service.impl;

import org.shahbaz.springaop.service.MessageService;

public class TwitterService implements MessageService {

	public void sendMessage(String message) {
		System.out.println("Posting a tweet");
	}

	public void sendMessageWithAccessToken(String message, String token) {
		System.out.println("Posting a tweet with valid access token");
	}

	public void sendMessageWithImage(String message, String imagePath) {
		System.out.println("Posting tweet with image");
	}

	public String reciveMessage() {
		return "Hello Twitter";
	}

}
