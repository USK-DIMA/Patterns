package ru.uskov.dmitry.exercise.model.board;

import ru.uskov.dmitry.exercise.model.common.BabyChair;
import ru.uskov.dmitry.exercise.model.driver.TaxiDriver;

public class Taxi extends Board {

    private BabyChair babyChair;

    private static final Class driverClass = TaxiDriver.class;

    public static final int MAX_PASSENGER = 4;

    public Taxi() {
        super(driverClass, MAX_PASSENGER);
    }

    public BabyChair getBabyChair() {
        return babyChair;
    }

    public void setBabyChair(BabyChair babyChair) {
        this.babyChair = babyChair;
    }
}
