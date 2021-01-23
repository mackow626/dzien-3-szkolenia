package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Movie> movieList = new ArrayList<>();

    public static void main(String[] args) {
        displayMenu();
        dataPreparation();
        selectMenu();

    }

    private static void selectMenu() {
        Scanner scanner = new Scanner(System.in);
        String selectMenu = scanner.nextLine();

        switch (selectMenu) {
            case "1":
                System.out.println("Dodaj film");
                break;
            case "2":
                searchMovieByName();
                break;
            case "3":
                System.out.println("Wypisz film z zakresu dat");
                break;
            case "4":
                searchMoviesForActor();
                break;
            case "5":
                System.out.println("Ile kosztowało wyprodukowanie danego filmu");
                break;
            default:
                System.out.println("Wyjsci z menu");
        }
    }

    private static void displayMenu() {
        System.out.println("Wybierz z menu:\n" +
                "1. Dodaj film\n" +
                "2. Szukaj filmu po nazwie\n" +
                "3. Wypisz film z zakresu dat\n" +
                "4. Sprawdz w jakich filmach grał dany aktor\n" +
                "5. Ile kosztowało wyprodukowanie danego filmu");
    }

    private static void dataPreparation() {
        Director stevenSpilberg = new Director("Steven", "Spilberg", 1000, true);
        Director jamesCameron = new Director("James", "Cameron", 1200, false);

        Actor tomHanks = new Actor("Tom", "Hanks", 500, Sex.men);
        Actor juliaRoberts = new Actor("Julia", "Roberts", 600, Sex.female);
        Actor sylvesterStalone = new Actor("Sylvester", "Stalone", 400, Sex.men);
        Actor nicolKidman = new Actor("Nicole", "kidman", 450, Sex.female);


        Movie titanic = new Movie("Titanic", stevenSpilberg, LocalDate.of(2020, 1, 23),
                Arrays.asList(tomHanks, juliaRoberts, nicolKidman), MovieType.romantic);

        Movie rambo = new Movie("Rambo", jamesCameron, LocalDate.of(1988, 1, 23),
                Arrays.asList(sylvesterStalone, juliaRoberts, nicolKidman), MovieType.action);
        movieList = Arrays.asList(titanic, rambo);
    }

    private static void searchMoviesForActor() {
        System.out.println("Podaj nazwisko aktora");
        Scanner scanner2 = new Scanner(System.in);
        String actorLastName = scanner2.nextLine();
        for (Movie movie : movieList) {
            for (Actor actor : movie.getActors()) {
                if (actor.getLastName().equals(actorLastName)) {
                    System.out.println(movie.getTitle());
                }
            }
        }
    }

    private static void searchMovieByName() {
        System.out.println("Podaj nazwe filmu");
        Scanner scanner1 = new Scanner(System.in);
        String movieTitle = scanner1.nextLine();
        for (Movie movie : movieList) {
            if (movieTitle.equals(movie.getTitle())) {
                System.out.println(movie.toString());
            }
        }
    }
}
