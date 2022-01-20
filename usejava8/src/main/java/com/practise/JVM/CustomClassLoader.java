//package com.practise.JVM;
//
//import java.io.FileNotFoundException;
//
///**
// * @Description TODO
// * @Author lianggao
// * @Date 2021/11/28 下午5:23
// * @Version 1.0
// */
//public class CustomClassLoader extends ClassLoader {
//    @Override
//    protected Class<?> findClass(String name) {
//
//        byte[] result = getClassFromCustomPath();
//        if (result == null) {
//            try {
//                throw new FileNotFoundException();
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }
//        }
//        return defineClass(name, result, 0, result.length);
//    }
//
//
//    private byte[] getClassFromCustomPath(String name) {
//        //从自定义路径中加载指定类：字节略
//        //name可以是加密的，然后再解密
//        return null;
//    }
//}
