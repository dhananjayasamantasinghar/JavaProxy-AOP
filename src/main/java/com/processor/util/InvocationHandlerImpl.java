package com.processor.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InvocationHandlerImpl implements InvocationHandler {
	
	private final Object original;

	public InvocationHandlerImpl(Object original) {
		this.original = original;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		beforAdvice();
		Object res = method.invoke(original, args);
		afterAdvice();
		
		return res;
	}
	
	public void beforAdvice(){
		System.out.println("Check in Cache");
	}
	
	public void afterAdvice(){
		System.out.println("Put in cache");
	}
}
