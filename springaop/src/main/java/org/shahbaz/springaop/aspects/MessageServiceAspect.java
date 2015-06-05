package org.shahbaz.springaop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.shahbaz.springaop.application.exception.exceptiontypes.ExceptionType;
import org.shahbaz.springaop.application.exception.message.ApplicationRuntimeException;
import org.shahbaz.springaop.service.impl.TwitterService;

@Aspect
public class MessageServiceAspect {

	public static final int ARG_ZERO = 0;
	public static final int ARG_ONE = 1;
	public static final int TWEET_MAX_LENGTH = 140;
	public static final String ACCESS_TOKEN = "QKJEKHDSD8839SDKJDJ299213KDJ";

	/**
	 * Validation before sending message.
	 * 
	 * @param joinPoint
	 * @throws Exception
	 */
	@Before("execution(public void org.shahbaz.springaop.service.impl.TwitterService.sendMessageWithAccessToken(..))")
	public void preSendMessageValidation(JoinPoint joinPoint) throws Exception {

		String lMessage = (String) joinPoint.getArgs()[ARG_ZERO];
		String lAccessToken = (String) joinPoint.getArgs()[ARG_ONE];
		validateMessage(lMessage);
		validateAccesstoken(lAccessToken);
	}

	/**
	 * If message is sent without any exception then display a success message.
	 * Note : <code>@After</code> annotation will execute even if the
	 * <code>sendMessageWithAccessToken()</code> had an exception in between but
	 * <code>@AfterReturning</code> will only execute if
	 * <code>sendMessageWithAccessToken()</code> was invoked and execute
	 * successfully.
	 */
	@AfterReturning("execution(public void org.shahbaz.springaop.service.impl.TwitterService.sendMessageWithAccessToken(..))")
	public void postSendMessage() {
		System.out.println("Message was sent successfully");
	}

	/**
	 * On receive of all the messages first close all the service
	 * 
	 * @param proceedingJoinPoint
	 * @return
	 */
	@Around("execution(public * recive*(..))")
	public String onReceiveOfMessage(ProceedingJoinPoint proceedingJoinPoint) {
		Object lTargetObject = (Object) proceedingJoinPoint.getTarget();
		String recivedMessage = null;
		closeOtherServices(lTargetObject);

		try {
			recivedMessage = (String) proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}

		return addSalutationToMessage(recivedMessage);

	}

	/**
	 * Validate Access Token
	 * 
	 * @param lAccessToken
	 * @throws Exception
	 */
	private void validateAccesstoken(String lAccessToken) throws Exception {
		if (lAccessToken.isEmpty() || !lAccessToken.equals(ACCESS_TOKEN)) {
			throw new ApplicationRuntimeException(
					ExceptionType.INVALID_ACCESS_TOKEN);
		}
	}

	/**
	 * Validate Message
	 * 
	 * @param lMessage
	 * @throws Exception
	 */
	private void validateMessage(String lMessage) throws Exception {
		if (lMessage.isEmpty() || lMessage.length() > TWEET_MAX_LENGTH) {
			throw new ApplicationRuntimeException(ExceptionType.INVALID_MESSAGE);
		}
	}

	/**
	 * Closing other services.
	 * 
	 * @param lTargetObject
	 */
	private void closeOtherServices(Object lTargetObject) {
		if (lTargetObject instanceof TwitterService) {
			System.out.println("Save current tweets and close");
		} else {
			System.out.println("Close After running apps in 5 minutes");
		}
	}

	/**
	 * 
	 * @param recivedMessage
	 * @return
	 */
	private String addSalutationToMessage(String recivedMessage) {
		return "You have a message ! \n\n" + recivedMessage + "\n\n Bye :) ";
	}
}
