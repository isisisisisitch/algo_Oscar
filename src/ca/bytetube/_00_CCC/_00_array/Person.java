package ca.bytetube._00_CCC._00_array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Person implements Comparable<Person>{
    int age;
    double height;
    String name;//LexicographicalOrder


    public Person(int age, double height, String name) {
        this.age = age;
        this.height = height;
        this.name = name;
    }

    @Override
    public String toString() {
        return "{age:" + age +
                ", height:" + height +
                ", name:'" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Person p) {
        return Double.compare(this.height,p.height);//
    }


    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(10);
        Person[] persons = new Person[5];
        Person p1 = new Person(10,16.5d,"david");
        Person p2 = new Person(12,17.5d,"Oscar");
        Person p3 = new Person(16,19.0d,"jim");
        Person p4 = new Person(13,17.4d,"mike");
        Person p5 = new Person(20,17.2d,"frank");
        persons[0] = p1;
        persons[1] = p2;
        persons[2] = p3;
        persons[3] = p4;
        persons[4] = p5;
        printArray(persons);
        System.out.println("after sort");
        Arrays.sort(persons,new PersonComparator());//ClassCastException
        printArray(persons);


    }

    public static void printArray( Person[] persons){
        for (Person p :persons) {
            System.out.print(p+"   ");
        }
        System.out.println();
    }


}
