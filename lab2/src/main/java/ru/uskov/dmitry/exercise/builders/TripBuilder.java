package ru.uskov.dmitry.exercise.builders;


import ru.uskov.dmitry.exercise.exception.BabyChairException;
import ru.uskov.dmitry.exercise.exception.IncorrectDriverException;
import ru.uskov.dmitry.exercise.exception.OverflowPassangersException;
import ru.uskov.dmitry.exercise.exception.ZeroPassangersException;
import ru.uskov.dmitry.exercise.model.Trip;
import ru.uskov.dmitry.exercise.model.board.Board;
import ru.uskov.dmitry.exercise.model.common.BabyChair;
import ru.uskov.dmitry.exercise.model.common.Passenger;
import ru.uskov.dmitry.exercise.model.driver.Driver;

import java.util.ArrayList;

public interface TripBuilder {
    Trip build() throws IncorrectDriverException, ZeroPassangersException, OverflowPassangersException, BabyChairException;

    void printLog();

    TripBuilder board(Board board);
    TripBuilder driver(Driver driver);
    TripBuilder passengers(ArrayList<Passenger> passengers);
    TripBuilder babyChair(BabyChair babyChair);
}
