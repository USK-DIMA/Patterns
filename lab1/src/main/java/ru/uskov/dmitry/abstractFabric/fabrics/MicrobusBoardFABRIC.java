package ru.uskov.dmitry.abstractFabric.fabrics;

import ru.uskov.dmitry.abstractFabric.model.board.Board;
import ru.uskov.dmitry.abstractFabric.model.board.Microbus;


public class MicrobusBoardFabric implements BoardFabric{

    @Override
    public Board createBoard() {
        return new Microbus();
    }
}
