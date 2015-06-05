package org.shahbaz.springaop.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.shahbaz.springaop.application.exception.message.ApplicationRuntimeException;

@Aspect
public class LoggingAspect {

	/**
	 * This will get called only on execution of sendMessage() of EmailService
	 * class
	 */
	@Before("execution(public void org.shahbaz.springaop.service.impl.EmailService.sendMessage(..))")
	public void loggingAdviceForSpecificObject() {
		System.out.println("Logging : Before sendMessage() of email is called");
	}

	/**
	 * We are using wild cards here.This gets invoked before any public method
	 * with starts with the word *send*
	 */
	@Before("execution(public * send*(..))")
	public void loggingAdviceForAllSending() {
		System.out.println("Logging : Before sending is called");
	}

	/**
	 * This will refer the poitcut expression of
	 * loggingAdvicePointcutForAllReceive()
	 */
	@After("loggingAdvicePointcutForAllReceive()")
	public void loggingAdviceAfterReciveMessage() {
		System.out.println("Logging : Message recived , Resuming all task");
	}

	/**
	 * This will refer the poitcut expression of
	 * loggingAdvicePointcutForAllReceive()
	 */
	@Before("loggingAdvicePointcutForAllReceive()")
	public void loggingAdviceForAllReciveMessage() {
		System.out.println("Logging : A message is about to be received");
	}

	/**
	 * This will refer the poitcut expression of
	 * loggingAdvicePointcutForAllReceive()
	 */
	@Before("loggingAdvicePointcutForAllReceive()")
	public void loggingAdviceForAllReciveMessageNotify() {
		System.out
				.println("Logging : All your activity is stopped, it will be resumed after you recive a message.");
	}

	/**
	 * This pointcut is used because we want to call the above three methods for
	 * all receiveMessage(). The expression used here will be used by the above
	 * two methods at run time
	 */
	@Pointcut("execution(public * recive*(..))")
	public void loggingAdvicePointcutForAllReceive() {

	}

	@Before("loggingAdviceForAllSms()")
	public void loggingAdviceBeforSmsOnly() {
		System.out.println("SMS service will be called");
	}

	@After("loggingAdviceForAllSms()")
	public void loggingAdviceAfterSmsOnly() {
		System.out.println("Closing SMS Service");
	}

	/**
	 * This will apply on any methods that is getting called on SmsServiceClass
	 */
	@Pointcut("within( org.shahbaz.springaop.service.impl.SmsService)")
	public void loggingAdviceForAllSms() {

	}

	/**
	 * This method will execute for all method with some arguments and will only
	 * get executed if there is any exception that happens while executing.
	 * 
	 * Note : The argument name in <code>@AfterThrowing</code> and in the method
	 * signature should match.
	 * 
	 * @param applicationRuntimeException
	 */
	@AfterThrowing(pointcut = ("args(..)"), throwing = "applicationRuntimeException")
	public void logAllExcpetionThrown(
			ApplicationRuntimeException applicationRuntimeException) {
		System.out.println("Opps an exception has occured :(");
		System.out.println("EXCEPTION : " + applicationRuntimeException);
	}

}
