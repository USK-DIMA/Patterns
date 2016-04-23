package ru.uskov.dmitry;

import java.awt.*;

/**
 * Created by Dmitry on 23.04.2016.
 */
public class GameBack {
    private Color color;

    public GameBack() {
        this.color = Color.BLACK;
    }


    public void draw(Graphics2D g){
        g.setColor(color);
        g.fillRect(0, 0, MyJPanel.WIDTH, MyJPanel.HEIGHT);
    }

}
