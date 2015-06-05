package org.shahbaz.springaop.service;

public interface MessageService {

	public void sendMessage(String message);

	public void sendMessageWithImage(String message, String imagePath);

	public String reciveMessage();

	public void sendMessageWithAccessToken(String message, String token);
}
