package ru.uskov.dmitry.exercise.model;

import ru.uskov.dmitry.exercise.model.board.Board;
import ru.uskov.dmitry.exercise.model.common.Passenger;
import ru.uskov.dmitry.exercise.model.driver.Driver;

import java.util.ArrayList;

public class Trip {

    private Driver driver;

    private Board board;

    private ArrayList<Passenger> passengers;

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }
}
