package com.practise.java8.useOOP;

public class Stu {
    private String name;
    private Integer age;
    private String hobby;

    public Stu() {
    }

    public Stu(String name, Integer age, String hobby) {
        this.name = name;
        this.age = age;
        this.hobby = hobby;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }


    @Override
    public String toString() {
        return "Stu{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", hobby='" + hobby + '\'' +
                '}';
    }

    private void running() {
        System.out.print("running");
    }


    public void useThis() {
        running();
        //System.out.print(this);
    }
}
