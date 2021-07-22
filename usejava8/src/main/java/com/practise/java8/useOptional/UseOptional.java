package com.practise.java8.useOptional;

import java.util.Optional;

public class UseOptional {
    public static void main(String[] args) {


        Optional<Car> empty = getOptionalInstanceWithDiffWay();
        //你可以把Optional对象看成一种特殊的集合数据，它至多包含一个元素。
        //如果Optional包含一个值，那函数就将该值作为参数传递给map，对该值进行转换。
        //如果Optional为空，就什么也不做。

        Optional<Car> optInsurance = Optional.of(new Car());
        //类似于流中的map
        //Optional<Optional<Insurance>> insurance = optInsurance.map(Car::getInsurance);  //嵌套使用optional
        final Optional<Insurance> insurance = optInsurance.flatMap(Car::getInsurance); //使用flatMap扁平化optional



        System.out.println(insurance);
    }

    private static Optional<Car> getOptionalInstanceWithDiffWay() {
        Optional<Car> empty = Optional.empty(); //创建一个空的Optional。语义上和null一样，但实际引用null会触发NullPointerException。

        Optional<Car> car = Optional.of(new Car()); //依据一个非空值创建optional

        Optional<Car> car1 = Optional.ofNullable(new Car()); //可以接收null的Optional。
        return empty;
    }
}
