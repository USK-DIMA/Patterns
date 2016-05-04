package ru.uskov.dmitry.view;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Dmitry on 23.04.2016.
 */
public class MainForm {
    JFrame frame;
    private JRadioButton radioButton1;
    private MyJPanel myPanel;
    private BufferedImage image;
    private Graphics2D graphics2D;

    public MainForm(){
        JFrame frame = new JFrame("MainForm");
        myPanel = new MyJPanel();
        frame.setContentPane(myPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
