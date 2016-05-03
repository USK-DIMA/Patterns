package ru.uskov.dmitry.abstractFabric.model.board;

import ru.uskov.dmitry.abstractFabric.model.driver.MicrobusDriver;


public class Microbus extends Board {

    private static final Class driverClass = MicrobusDriver.class;

    public static final int MAX_PASSENGER = 15;

    public Microbus() {
        super(driverClass, MAX_PASSENGER);
    }
}
