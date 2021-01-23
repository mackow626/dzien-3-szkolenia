package com.company;

public class Actor extends Staff{
    Sex sex;

    public Actor(String firstName, String lastName, double salary, Sex sex) {
        super(firstName, lastName, salary);
        this.sex = sex;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "sex=" + sex +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                '}';
    }
}
