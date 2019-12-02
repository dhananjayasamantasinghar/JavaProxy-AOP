package com.processor.util;

import java.lang.reflect.Proxy;

import com.processor.PricingCalculator;

public class CalculatorFactory {

	public static ICalculator create() {
		InvocationHandlerImpl handler = new InvocationHandlerImpl(new PricingCalculator());
		ICalculator service = (ICalculator) Proxy.newProxyInstance(ICalculator.class.getClassLoader(), new Class[] { ICalculator.class },
				handler);
		return service;
	}

}
