package com.practise.designpattern.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
	//ά��һ��Ŀ�����Object
	private Object target;
	public ProxyFactory(Object target) {
		this.target = target;
	} 
	
	//��Ŀ����� ����һ���������
	public Object getProxyInstance() {
		return Proxy.newProxyInstance(
				//�����+ʵ�ֽӿڣ��ܶ�̬ʵ��
				target.getClass().getClassLoader(),
				target.getClass().getInterfaces(),
				new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println("JDK����ʼ~~");
						Object returnVal = method.invoke(target, args);//������Ƶ���Ŀ�����ķ���
						System.out.println("JDK�����ύ");
						return returnVal; //���ص���Ŀ�����
					}
				});
	}
}
