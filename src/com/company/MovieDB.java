package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MovieDB {
    static List<Movie> movieList = new ArrayList<>();
    static List<Actor> actorList = new ArrayList<>();
    static List<Director> directorList = new ArrayList<>();

     static void selectMenu() { //todo dodaj jeszcze dwie opcje dodaj aktora i reżysera
        boolean counter = true;
        while (counter) {
            displayMenu();
            Scanner scanner = new Scanner(System.in);
            String selectMenu = scanner.nextLine();

            switch (selectMenu) {
                case "1":
                    addMovie();
                    break;
                case "2":
                    searchMovieByName();
                    break;
                case "3":
                    System.out.println("Wypisz film z zakresu dat"); //todo zaimplementuj metody
                    break;
                case "4":
                    searchMoviesForActor();
                    break;
                case "5":
                    showCostOfMovie();
                    break;
                case "0":
                    counter = false;
                    break;
                default:
                    counter = false;
            }
        }
    }

    private static void addMovie() {
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);

        System.out.println("Podaj tytuł");
        String title = scanner1.nextLine();
        System.out.println("Podaj nazwisko reżysera");
        String directorLastName = scanner1.nextLine();

        Director director = null;
        for (Director directorFromList : directorList) {
            if (directorFromList.getLastName().equals(directorLastName)) {
                director = directorFromList;
            }
        }

        System.out.println("Podaj dzien premiery");
        int day = scanner2.nextInt();
        System.out.println("Podaj miesiac premiery");
        int month = scanner2.nextInt();
        System.out.println("Podaj rok premiery");
        int year = scanner2.nextInt();
        System.out.println("Podaj ilosc aktorow");
        int actorsNumber = scanner2.nextInt();
        List<Actor> actorListOfCurrentMowie = new ArrayList<>();

        for (int i = 0; i < actorsNumber; i++) {
            System.out.println(" Podaj nazwisko aktora");
            Scanner scanner3 = new Scanner(System.in);
            String actorName = scanner3.nextLine();
            for (Actor actor : actorList) {
                if (actor.getLastName().equals(actorName)) {
                    actorListOfCurrentMowie.add(actor);
                }
            }
        }

        System.out.println("Podaj typ z  " +
                "    horror,\n" +
                "    romantic,\n" +
                "    action");
        String movieTypeFromUser = scanner1.nextLine();
        MovieType movieType;
        switch (movieTypeFromUser){
            case "horror":
                movieType = MovieType.horror;
                break;
            case "romantic":
                movieType = MovieType.romantic;
                break;
            case "action":
                movieType = MovieType.action;
                break;
            default:
                movieType=null;
        }


        Movie movie = new Movie(title, director, LocalDate.of(year, month, day), actorListOfCurrentMowie,movieType);
        movieList.add(movie);
    }

    private static void showCostOfMovie() {
        System.out.println("Podaj nazwe filmu");
        Scanner scanner3 = new Scanner(System.in);
        String movieTitle = scanner3.nextLine();

        for (Movie movie : movieList) {
            if (movieTitle.equals(movie.getTitle())) {
                double cost = movie.getDirector().getSalary();
                for (Actor actor : movie.getActors()) {
                    cost = cost + actor.getSalary();
                }
                System.out.println(cost);
            }
        }
    }

    private static void displayMenu() {
        System.out.println("Wybierz z menu:\n" +
                "1. Dodaj film\n" +
                "2. Szukaj filmu po nazwie\n" +
                "3. Wypisz film z zakresu dat\n" +
                "4. Sprawdz w jakich filmach grał dany aktor\n" +
                "5. Ile kosztowało wyprodukowanie danego filmu\n" +
                "0. Wyjscie");
    }

     static void dataPreparation() { //todo dodac wczytywanie z pliku
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
        movieList.add(rambo);
        movieList.add(titanic);
        actorList = Arrays.asList(tomHanks, juliaRoberts, sylvesterStalone, nicolKidman);
        directorList = Arrays.asList(jamesCameron, stevenSpilberg);
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
