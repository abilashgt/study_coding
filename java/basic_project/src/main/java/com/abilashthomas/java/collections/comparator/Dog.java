package com.abilashthomas.java.collections.comparator;

import java.util.Comparator;

/**
 * Created by abilash on 30/10/16.
 * Reference: https://www.tutorialspoint.com/java/java_using_comparator.htm
 */
public class Dog implements Comparator<Dog>, Comparable<Dog>{
    String name;
    int age;

    public Dog(){}

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int compareTo(Dog o) {
        return 0;
    }

    public int compare(Dog o1, Dog o2) {
        return o1.age-o2.age;
    }
}
