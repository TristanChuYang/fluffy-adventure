package com.tristan.viii.methodreferences;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

//方法引用提供了一些新的语法去调用方法
public class Car {
    public static Car create(final Supplier<Car> supplier) {
        return supplier.get();
    }

    public static void collide(final Car car) {
        System.out.println("Collided " + car.toString());
    }

    public void follow(final Car another) {
        System.out.println("Following the " + another.toString());
    }

    public void repair() {
        System.out.println("Repaired " + this.toString());
    }

    public static void main(String[] args) {

        Car car = Car.create(Car::new);
        final List<Car> cars = Arrays.asList(car);
        cars.forEach(Car::collide);
        cars.forEach(Car::repair);
        //这样是不可以的，因为follow不是一个静态方法
        //cars.forEach(Car::follow);
        //可以通过对象的实例引用
        cars.forEach(car::follow);

        final Car police = Car.create( Car::new );
        cars.forEach(police::follow );

    }
}
