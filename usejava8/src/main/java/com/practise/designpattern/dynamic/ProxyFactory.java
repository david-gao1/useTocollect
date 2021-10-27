package com.practise.designpattern.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
	//维护一个目标对象：Object
	private Object target;
	public ProxyFactory(Object target) {
		this.target = target;
	} 
	
	//给目标对象 生成一个代理对象
	public Object getProxyInstance() {
		return Proxy.newProxyInstance(
				//类加载+实现接口，能动态实现
				target.getClass().getClassLoader(),
				target.getClass().getInterfaces(),
				new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println("JDK代理开始~~");
						Object returnVal = method.invoke(target, args);//反射机制调用目标对象的方法
						System.out.println("JDK代理提交");
						return returnVal; //返回的是目标对象
					}
				});
	}
}
