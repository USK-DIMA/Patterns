package ru.uskov.dmitry.abstractFabric.model.board;

import ru.uskov.dmitry.abstractFabric.model.driver.BusDriver;

public class Bus extends Board {

    private static final Class driverClass = BusDriver.class;

    public static final int MAX_PASSENGER = 30;

    public Bus() {
        super(driverClass, MAX_PASSENGER);
    }
}
