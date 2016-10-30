package collections.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by abilash on 30/10/16.
 * Reference: https://www.tutorialspoint.com/java/java_using_comparator.htm
 */
public class DogExample {
    public static void main(String[] args) {
        List<Dog> list = new ArrayList<Dog>();

        list.add(new Dog("Shaggy", 3));
        list.add(new Dog("Lacy", 2));
        list.add(new Dog("Roger", 10));
        list.add(new Dog("Tommy", 4));
        list.add(new Dog("Tammy", 1));

        Collections.sort(list);
        print(list);

        System.out.println("\n\nSort using comparator:");
        Collections.sort(list, new Dog());
        print(list);
    }

    public static void print(List<Dog> list){
        for (Dog d:list){
            System.out.print(d.name+"-"+d.age+",");
        }
    }

}
