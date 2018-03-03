package com.gmail.herman.uladzimir.project.model.entity;

import java.util.Objects;

public class Person implements Comparable<Person> {
    String name;
    String surname;
    int age;

    public Person(){}

    public Person(String name, String surname, int age){
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name) &&
                Objects.equals(surname, person.surname);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, surname, age);
    }

    @Override
    public String toString() {
        return name + " " + surname + ", age: " + age;
    }

    //sorts first by surname, and then by name
    @Override
    public int compareTo(Person o) {
        int result = surname.compareTo(o.surname);

        if (result == 0) {
            return name.compareTo(o.name);
        }

        return result;
    }

}