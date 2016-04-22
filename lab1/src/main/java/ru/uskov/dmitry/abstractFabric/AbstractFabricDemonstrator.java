package ru.uskov.dmitry.abstractFabric;

import ru.uskov.dmitry.DemonstratorSystemOut;
import ru.uskov.dmitry.abstractFabric.annotations.DriverType;
import ru.uskov.dmitry.abstractFabric.annotations.FabricType;
import ru.uskov.dmitry.abstractFabric.exception.IncorrectDriverException;
import ru.uskov.dmitry.abstractFabric.fabrics.BoardFabric;
import ru.uskov.dmitry.abstractFabric.model.board.Board;
import ru.uskov.dmitry.abstractFabric.model.common.Passenger;
import ru.uskov.dmitry.abstractFabric.model.driver.Driver;

import javax.inject.Inject;


public class AbstractFabricDemonstrator extends DemonstratorSystemOut{

    public static final String DEMONSTRATION_NAME = "AbstractFabricDemonstrator";

    @Inject @FabricType(type = "taxi")
    private BoardFabric boardFabric;

    @Inject @DriverType(type="taxi")
    private Driver driver;

    public AbstractFabricDemonstrator() {
        super(DEMONSTRATION_NAME);
    }

    @Override
    protected void run() {
        Passenger[] passengers = new Passenger[5];

        for (int i = 0; i < passengers.length; i++){
            passengers[i]= new Passenger();
        }

        Board board = boardFabric.createBoard();

        System.out.println(board.isEmpty());
        System.out.println(board.driverIsHere());
        System.out.println("Добавляем водителя");
        try {
            board.setDriver(driver);
        } catch (IncorrectDriverException e) {
            e.printStackTrace();
        }
        System.out.println("Добавлено пассажиров: "+ board.addPassengers(passengers));
        System.out.println(board.isEmpty());
        System.out.println(board.driverIsHere());
        System.out.println(board.readyToRun());
    }
}
