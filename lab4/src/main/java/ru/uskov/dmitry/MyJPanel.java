package ru.uskov.dmitry;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;


public class MyJPanel extends JPanel implements MouseListener{
    public static final int WIDTH=400;
    public static final int HEIGHT=400;
    private BufferedImage image;
    private Graphics2D g;
    private GameBack background;
    private ImageCreator imageCreator;

    public MyJPanel(){
        super();
        this.addMouseListener(this);
        imageCreator = new ImageCreatorProxy();
        image = imageCreator.getBackground();
        g = (Graphics2D) image.getGraphics();
        background = new GameBack();
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);
        requestFocus();
        Thread thread = new Thread(){
            @Override
            public void run() {
                while (true){
                    draw();
                }
            }
        };
        thread.start();

    }

    public void draw(){
        background.draw(g);
        Graphics g2 = this.getGraphics();
        if(g2 != null) {
            g2.drawImage(image, 0, 0, null);
        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        image = imageCreator.getImage();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
