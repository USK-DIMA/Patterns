package ru.uskov.dmitry.exercise;

import ru.uskov.dmitry.exercise.builders.TripBuilder;
import ru.uskov.dmitry.exercise.builders.TripBuilderImpl;
import ru.uskov.dmitry.exercise.exception.BabyChairException;
import ru.uskov.dmitry.exercise.exception.IncorrectDriverException;
import ru.uskov.dmitry.exercise.exception.OverflowPassangersException;
import ru.uskov.dmitry.exercise.exception.ZeroPassangersException;
import ru.uskov.dmitry.exercise.model.Trip;
import ru.uskov.dmitry.exercise.model.board.Board;
import ru.uskov.dmitry.exercise.model.board.Taxi;
import ru.uskov.dmitry.exercise.model.common.Passenger;
import ru.uskov.dmitry.exercise.model.driver.Driver;
import ru.uskov.dmitry.exercise.model.driver.TaxiDriver;

import java.util.ArrayList;


public class Client {

    Trip trip;

    TripBuilder builder;

    public Client(TripBuilder builder) {
        this.builder = builder;
    }

    public void startDemonstration(){

        try {
            trip = builder.build();
            System.out.println("Можно отправляться");
        } catch (NullPointerException e){
            System.out.println("Переданы не все составляющие для поездки");
        } catch (IncorrectDriverException e) {
            System.out.println("Данный водитель не может управлять предложенным транспортным средством");
        } catch (ZeroPassangersException e) {
            System.out.println("Кол-во пассажиров: 0. Поездка невозможна без пассажиров");
        } catch (OverflowPassangersException e) {
            System.out.println("Слишком много пассажиров для данного транспортного средства");
        } catch (BabyChairException e) {
            System.out.println("Для данной поездки необходимо детское кресло");
        }
        finally {
            System.out.println("======================================================================");
        }
    }


}
