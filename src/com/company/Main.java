package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Wybierz z menu:\n" +
                "1. Dodaj film\n" +
                "2. Szukaj filmu po nazwie\n" +
                "3. Wypisz film z zakresu dat\n" +
                "4. Sprawdz w jakich filmach grał dany aktor\n" +
                "5. Ile kosztowało wyprodukowanie danego filmu");
        Scanner scanner = new Scanner(System.in);
        String selectMenu = scanner.nextLine();

        switch (selectMenu) {
            case "1":
                System.out.println("Dodaj film");
                break;
            case "2":
                System.out.println("Szukaj filmu po nazwie");
                break;
            case "3":
                System.out.println("Wypisz film z zakresu dat");
                break;
            case "4":
                System.out.println("Sprawdz w jakich filmach grał dany aktor");
                break;
            case "5":
                System.out.println("Ile kosztowało wyprodukowanie danego filmu");
                break;
            default:
                System.out.println("Wyjsci z menu");
        }


        Director stevenSpilberg = new Director("Steven", "Spilberg", 1000, true);
        Director jamesCameron = new Director("James", "Cameron", 1200, false);

        Actor tomHanks = new Actor("Tom", "Hanks", 500,Sex.men);
        Actor juliaRoberts = new Actor("Julia", "Roberts", 600, Sex.female);
        Actor sylvesterStalone = new Actor("Sylvester", "Stalone", 400, Sex.men);
        Actor nicolKidman = new Actor("Nicole", "kidman", 450, Sex.female);


        Movie titanic = new Movie("Titanic",stevenSpilberg, LocalDate.of(2020,1,23),
                Arrays.asList(tomHanks,juliaRoberts,nicolKidman),MovieType.romantic);

        Movie rambo = new Movie("Rambo",jamesCameron, LocalDate.of(1988,1,23),
                Arrays.asList(sylvesterStalone,juliaRoberts,nicolKidman),MovieType.action);

        List<Movie> movieList =  Arrays.asList(titanic,rambo);




    }
}
