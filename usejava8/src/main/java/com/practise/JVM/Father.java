package com.practise.JVM;

class Father {
    public static void print(String str) {
        System.out.println("father " + str);
    }

    private void show(String str) {
        System.out.println("father" + str);
    }
}

class Son extends Father {
    public static class VirtualMethodTest {
        public static void main(String[] args) {


            Son.print("coder");
            //Father fa=new Father();
            //fa.show("atguigu.com");
        }
    }
}