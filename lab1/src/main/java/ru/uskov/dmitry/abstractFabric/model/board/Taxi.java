package ru.uskov.dmitry.abstractFabric.model.board;

import ru.uskov.dmitry.abstractFabric.model.driver.TaxiDriver;


public class Taxi extends Board {

    private static final Class driverClass = TaxiDriver.class;

    public static final int MAX_PASSENGER = 3;

    public Taxi() {
        super(driverClass, MAX_PASSENGER);
    }

}
