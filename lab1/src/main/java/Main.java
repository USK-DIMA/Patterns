
import ru.uskov.dmitry.abstractFabric.exception.IncorrectDriverException;
import ru.uskov.dmitry.abstractFabric.fabrics.BoardFabric;
import ru.uskov.dmitry.abstractFabric.fabrics.BusBoardFabric;
import ru.uskov.dmitry.abstractFabric.fabrics.MicrobusBoardFabric;
import ru.uskov.dmitry.abstractFabric.fabrics.TaxiBoardFabric;
import ru.uskov.dmitry.abstractFabric.model.board.Board;
import ru.uskov.dmitry.abstractFabric.model.common.Passenger;
import ru.uskov.dmitry.abstractFabric.model.driver.BusDriver;
import ru.uskov.dmitry.abstractFabric.model.driver.Driver;
import ru.uskov.dmitry.abstractFabric.model.driver.MicrobusDriver;
import ru.uskov.dmitry.abstractFabric.model.driver.TaxiDriver;

public class Main {


    public static void main(String[] args) {
        BoardFabric boardFabric;
        Driver driver;
        int pass;

        boardFabric = new TaxiBoardFabric();
        driver = new TaxiDriver();
        pass = 3;
        gogo(boardFabric, driver, pass);


        boardFabric = new MicrobusBoardFabric();
        driver = new MicrobusDriver();
        pass = 3;
        gogo(boardFabric, driver, pass);


        boardFabric = new BusBoardFabric();
        driver = new BusDriver();
        pass = 12;
        gogo(boardFabric, driver, pass);

        boardFabric = new BusBoardFabric();
        driver = new TaxiDriver();
        pass = 12;
        gogo(boardFabric, driver, pass);
    }

    public static void gogo(BoardFabric fabric, Driver driver, int pass) {
        System.out.println("========================================================");
        System.out.println("Фабрика: "+fabric.getClass().getSimpleName());
        System.out.println("Водитель: "+ driver.getClass().getSimpleName());
        Board board = fabric.createBoard();
        System.out.println("С помощью фабрики создан объект класа: "+ board.getClass().getSimpleName());
        System.out.println("Готовность транспорта: "+ board.readyToRun());
        try {
            System.out.println("Попытка посадить водиетля");
            board.setDriver(driver);
            System.out.println("Водитель успешо посажен");
        } catch (IncorrectDriverException e) {
            System.out.println("Не удалось посадить водителя");
        }

        System.out.println("Добавлено пассажиров: " + board.addPassengers(createPass(pass)));
        System.out.println("Готовность транспорта: "+ board.readyToRun());
        System.out.println("========================================================");

    }

    private static Passenger[] createPass(int pass) {
        Passenger[] p = new Passenger[pass];
        for(int i=0; i<pass; i++){
            p[i]= new Passenger();
        }
        return p;
    }


}
