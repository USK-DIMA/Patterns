package ru.uskov.dmitry.exercise;

import ru.uskov.dmitry.exercise.builders.TripBuilderImpl;
import ru.uskov.dmitry.exercise.model.Trip;
import ru.uskov.dmitry.exercise.model.board.Bus;
import ru.uskov.dmitry.exercise.model.board.Taxi;
import ru.uskov.dmitry.exercise.model.common.BabyChair;
import ru.uskov.dmitry.exercise.model.common.Passenger;
import ru.uskov.dmitry.exercise.model.driver.TaxiDriver;

import java.util.ArrayList;
import java.util.Random;


public class Main {
    public static void main(String[] args) {
       new Client(new TripBuilderImpl().board(new Taxi()).driver(new TaxiDriver()).passengers(new ArrayList<Passenger>()).babyChair(null)).startDemonstration();
        new Client(new TripBuilderImpl().board(new Bus()).driver(new TaxiDriver()).passengers(new ArrayList<Passenger>()).babyChair(null)).startDemonstration();
        new Client(new TripBuilderImpl().board(new Taxi()).driver(new TaxiDriver()).passengers(getRandomPassengers(4)).babyChair(null)).startDemonstration();
        new Client(new TripBuilderImpl().board(new Taxi()).driver(new TaxiDriver()).passengers(getRandomPassengers(4)).babyChair(new BabyChair())).startDemonstration();
    }

    private static ArrayList<Passenger> getRandomPassengers(int cout) {
        ArrayList<Passenger> passengers = new ArrayList<Passenger>(cout);
        for (int i=0; i<cout; i++){
            passengers.add(new Passenger(getCategory(new Random().nextInt(3))));
        }
        return passengers;
    }

    private static Passenger.Category getCategory(int i) {
        switch (i) {
            case 0 : return Passenger.Category.child;
            case 1 : return Passenger.Category.adult;
            case 2 : return Passenger.Category.benefit;
            default: return Passenger.Category.adult;
        }
    }
}
