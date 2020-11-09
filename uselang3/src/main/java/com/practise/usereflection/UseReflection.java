package com.practise.usereflection;

import com.practise.useOOP.Stu;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class UseReflection {
    public static void main(String[] args) throws Exception {
        //getStuClass();
        //getAInstance();
        //useFields();
        //useMethod();
        useConstructor();
    }

    private static void useConstructor() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        //1、getClass
        String stuClassString = "com.practise.useOOP.Stu";
        Class<?> stuClass = Class.forName(stuClassString); //获取一个特定的Class实例
        //2、getAllConstructor
        Constructor<?>[] declaredConstructors = stuClass.getDeclaredConstructors();
        for (Constructor constructor : declaredConstructors) {
            System.out.println("name:" + constructor.getName() +
                    "; modifiers:" + constructor.getModifiers() +
                    "; parameterTypes" + Arrays.toString(constructor.getParameterTypes()));
        }

        //3、获取一个构造器，并且通过一个构造器创建一个对象。
        Constructor<?> declaredConstructor = stuClass.getDeclaredConstructor(String.class, Integer.class, String.class);//设置属性的Class实例
        Object stuObject = declaredConstructor.newInstance("dada", 13, "running");
        System.out.println(((Stu) stuObject).getHobby());
    }

    private static void useMethod() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        //1、getClass
        final String stuClassString = "com.practise.useOOP.Stu";
        Class<?> stuClass = Class.forName(stuClassString); //获取一个特定的Class实例
        //2、遍历方法的属性
        Method[] declaredMethods = stuClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println("name:" + method.getName() +
                    "; returnType:" + method.getReturnType() +
                    "; modifiers:" + method.getModifiers() +
                    "; parameterTypes" + Arrays.toString(method.getParameterTypes()));
        }

        //3、获取方法，并调用此方法
        Method running = stuClass.getDeclaredMethod("running");//有参数的时候需要传数据类型的Class对象，比如：int.class.
        Object stuObject = stuClass.newInstance();
        running.setAccessible(true);
        running.invoke(stuObject);//有参数的时候可以传参，有返回值的时候可以接收返回值。
    }

    private static void useFields() throws ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        //1、getClass
        final String stuClassString = "com.practise.useOOP.Stu";
        Class<?> stuClass = Class.forName(stuClassString); //获取一个特定的Class实例
        //2、遍历所有变量属性
        final Field[] declaredFields = stuClass.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println("name:" + field.getName() + "; type:" + field.getType() + "; modifiers:" + field.getModifiers());
        }

        //3、获取对象属性，并操作此属性
        Field ageField = stuClass.getDeclaredField("age");
        ageField.setAccessible(true);//设置私有变量可以赋值，但是破坏了java的封装性
        Object StuObject = stuClass.newInstance();
        ageField.set(StuObject, 12);
        System.out.print(ageField.get(StuObject));
    }

    private static void getStuClass() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        //1、getClass
        Stu stu = new Stu("xiaoxiao", 12, "baseball");
        Class<? extends Stu> stuClass1 = stu.getClass();
        System.out.print(stuClass1.getName());//包的名字也作为类的一部分
        //2、Class.forName
        String stuClassString = "com.practise.useOOP.Stu";
        Class<?> stuClass2 = Class.forName(stuClassString);//2、获取一个特定的Class实例
        //3、class
        Class<Stu> stuClass3 = Stu.class;
        Stu stu1 = stuClass3.newInstance();//创建类的实例 //默认调用类的无参构造，如果没有无参构造则会抛出异常
    }

    private static void getAInstance() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        //将 forName 与 newlnstance 配合起来使用， 可以根据存储在字符串中的类名创建一个对象
        final String stuClassString = "com.practise.useOOP.Stu";
        Class<?> stuClass = Class.forName(stuClassString); //获取一个特定的Class实例
        final Object stu2 = stuClass.newInstance();
    }
}
