package ru.uskov.dmitry.proxy;

import ru.uskov.dmitry.view.MyJPanel;

import java.awt.image.BufferedImage;

/**
 * Created by Dmitry on 23.04.2016.
 */
public class ImageCreatorProxy implements ImageCreator {

    RealImageCreator realImageCreator;

    @Override
    public BufferedImage getBackground() {
        return new BufferedImage(MyJPanel.WIDTH, MyJPanel.HEIGHT, BufferedImage.TYPE_INT_BGR);
    }

    @Override
    public BufferedImage getImage() {
        if(realImageCreator == null){
            realImageCreator = new RealImageCreator();
        }
        return realImageCreator.getImage();
    }


}
