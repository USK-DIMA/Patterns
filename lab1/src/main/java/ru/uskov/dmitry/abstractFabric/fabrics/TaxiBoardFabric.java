package ru.uskov.dmitry.abstractFabric.fabrics;

import ru.uskov.dmitry.abstractFabric.annotations.FabricType;
import ru.uskov.dmitry.abstractFabric.model.board.Board;
import ru.uskov.dmitry.abstractFabric.model.board.Taxi;

/**
 * Created by Dmitry on 16.04.2016.
 */
@FabricType(type = "taxi")
public class TaxiBoardFabric implements BoardFabric {
    @Override
    public Board createBoard() {
        return new Taxi();
    }
}
