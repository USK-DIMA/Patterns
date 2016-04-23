package ru.uskov.dmitry;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Dmitry on 23.04.2016.
 */
public class RealImageCreator implements ImageCreator{
    @Override
    public BufferedImage getBackground() {
        return new BufferedImage(MyJPanel.WIDTH, MyJPanel.HEIGHT, BufferedImage.TYPE_INT_BGR);
    }

    @Override
    public BufferedImage getImage() {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("lab4/src/main/resources/TestImage.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}
