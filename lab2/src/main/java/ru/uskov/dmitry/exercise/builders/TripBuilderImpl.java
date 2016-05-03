package ru.uskov.dmitry.exercise.builders;

import ru.uskov.dmitry.exercise.exception.BabyChairException;
import ru.uskov.dmitry.exercise.exception.IncorrectDriverException;
import ru.uskov.dmitry.exercise.exception.OverflowPassangersException;
import ru.uskov.dmitry.exercise.exception.ZeroPassangersException;
import ru.uskov.dmitry.exercise.model.Trip;
import ru.uskov.dmitry.exercise.model.board.Board;
import ru.uskov.dmitry.exercise.model.board.Taxi;
import ru.uskov.dmitry.exercise.model.common.BabyChair;
import ru.uskov.dmitry.exercise.model.common.Passenger;
import ru.uskov.dmitry.exercise.model.driver.Driver;

import java.util.ArrayList;


public class TripBuilderImpl implements TripBuilder {

    private Driver driver;

    private Board board;

    private ArrayList<Passenger> passengers;

    private BabyChair babyChair;

    @Override
    public Trip build() throws IncorrectDriverException, ZeroPassangersException, OverflowPassangersException, NullPointerException, BabyChairException {
        printLog();
        if(driver==null || board==null || passengers==null){
            throw new NullPointerException();
        }

        Trip trip = new Trip();
        trip.setBoard(board);
        if(board.getDriverClass().isAssignableFrom(driver.getClass())){
            trip.setDriver(driver);
        }
        else{
            //Водитель не соответсвует транспортному средству
            throw new IncorrectDriverException();
        }

        if(passengers.size()==0){
            //Поездка невозможна без пассажиров
            throw new ZeroPassangersException();
        }
        if(passengers.size()>board.getMaxPassangerCount()){
            //Слишком много пассажиров
            throw new OverflowPassangersException();
        }
        trip.setPassengers(passengers);

        if(board.getClass().isAssignableFrom(Taxi.class) && isChild(passengers)){
            if(babyChair==null){
                throw new BabyChairException();
            }
            ((Taxi)board).setBabyChair(babyChair);
        }
        return trip;
    }

    @Override
    public void printLog() {
        System.out.println("======================================================================");
        System.out.println("Водитель: " + driver);
        System.out.println("Транспорт: " + board);
        int maxSize = 0;
        if(passengers!=null){
            maxSize = board.getMaxPassangerCount();
        }
        System.out.println("Мест в транспорте: "+maxSize);
        int size = 0;
        if(passengers!=null){
            size = passengers.size();
            System.out.println("Кол-во пассажиров: "+ size);
            System.out.println("Есть ли среди них дети: "+isChild(passengers));
        }
        else {
            System.out.println("Кол-во пассажиров: 0");
        }
        System.out.println("Предоставли ли кресло: "+ (babyChair!=null));
    }

    /**
     * Проверяет, есть ли среди пассажиров дети
     * @param passengers
     * @return true, если среди пассажиров рёбёнк
     */
    private boolean isChild(ArrayList<Passenger> passengers) {
        for(Passenger p: passengers){
            if(p.getCategory()== Passenger.Category.child){
                return true;
            }
        }
        return false;
    }

    @Override
    public TripBuilder board(Board board) {
        this.board = board;
        return this;
    }

    @Override
    public TripBuilder driver(Driver driver) {
        this.driver = driver;
        return this;
    }

    @Override
    public TripBuilder passengers(ArrayList<Passenger> passengers) {
        if(passengers == null) return this ;
        if(this.passengers==null){
            this.passengers = new ArrayList<Passenger>();
        }
        this.passengers.addAll(passengers);
        return this;
    }

    @Override
    public TripBuilder babyChair(BabyChair babyChair) {
        this.babyChair = babyChair;
        return this;
    }
}
