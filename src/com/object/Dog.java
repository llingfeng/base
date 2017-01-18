package com.object;

/**
 * Created by admin on 2016/8/26.
 */
public class Dog {
    private int age;
    private int weight;
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || this.getClass()!= o.getClass()) return false;
        Dog dog = (Dog) o;
        return age == dog.getAge();

    }

}
