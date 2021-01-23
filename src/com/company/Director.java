package com.company;

public class Director extends Staff{
    boolean patience;

    public Director(String firstName, String lastName, double salary, boolean patience) {
        super(firstName, lastName, salary);
        this.patience = patience;
    }

    @Override
    public String toString() {
        return "Director{" +
                "patience=" + patience +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                '}';
    }

    public boolean isPatience() {
        return patience;
    }

    public void setPatience(boolean patience) {
        this.patience = patience;
    }
}
