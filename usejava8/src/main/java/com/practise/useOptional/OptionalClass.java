package com.practise.useOptional;

import java.util.Optional;

public class OptionalClass {

}

/**
 * 在你的代码中始终如一地使用Optional，能非常清晰地界定出变量值的缺失是结构上的问
 * 题，还是你算法上的缺陷，抑或是你数据中的问题。ing
 */

/**
 * 一个人可能没有车用Optional处理没有车的情况
 */
class Person {
    private Optional<Car> car;

    public Optional<Car> getCar() {
        return car;
    }
}

/**
 * 车也可能没有保险
 */
class Car {
    private Optional<Insurance> insurance;

    public Optional<Insurance> getInsurance() {
        return insurance;
    }
}

/**
 * 保险一定会有名字
 */
class Insurance {
    private String name;

    public String getName() {
        return name;
    }
}
