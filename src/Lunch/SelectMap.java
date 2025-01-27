package Lunch;

import javax.swing.*;
import java.awt.*;

public abstract class SelectMap {

    public ImageIcon bigCoin = new ImageIcon("Asset/BigCoin.png");

    Image image2 = bigCoin.getImage().getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
    public ImageIcon smallCoin = new ImageIcon("Asset/Coin.png");

    Image image1 = smallCoin.getImage().getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);

    public ImageIcon pacManH = new ImageIcon("Asset/PacManOpenR.png");

    Image image3 = pacManH.getImage().getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);

    public ImageIcon heart = new ImageIcon("Asset/HEART.png");

    Image image4 = heart.getImage().getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);

    public int set1[]={
            1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
            1,2,4,4,4,4,4,4,4,4,4,4,4,4,1,
            1,3,1,1,1,1,1,4,1,3,1,3,1,3,1,
            1,4,1,4,3,4,4,4,1,3,1,3,3,3,1,
            1,3,1,3,1,1,1,4,1,3,1,1,1,3,1,
            1,4,4,4,4,3,3,3,4,3,4,3,3,3,1,
            1,3,1,1,1,3,1,1,1,1,1,1,1,3,1,
            1,3,4,4,4,3,3,3,3,3,4,3,3,3,1,
            1,1,1,3,1,1,1,1,3,1,1,3,1,1,1,
            1,3,4,3,3,3,3,3,3,1,3,3,3,3,1,
            1,4,1,1,1,1,3,1,3,1,1,3,1,3,1,
            1,3,3,4,4,4,4,3,4,3,4,3,1,3,1,
            1,4,1,1,1,3,1,1,1,3,1,1,1,3,1,
            1,4,3,4,4,4,3,3,4,4,4,4,3,4,1,
            1,1,1,1,1,1,1,1,1,1,1,1,1,1,1
    };
    public int set2[]={
            1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
            1,2,4,4,3,3,3,3,3,3,3,3,3,3,1,
            1,4,1,1,1,1,1,4,1,3,1,3,1,3,1,
            1,4,1,3,3,4,4,4,1,4,1,3,3,3,1,
            1,3,1,3,1,1,1,4,1,4,1,1,1,3,1,
            1,4,3,4,4,3,4,3,4,3,4,3,4,3,1,
            1,4,1,1,1,3,1,1,1,1,1,1,1,3,1,
            1,3,3,4,4,4,3,3,4,3,4,3,4,4,1,
            1,1,1,3,1,1,1,1,3,1,1,3,1,1,1,
            1,4,4,4,3,4,3,4,3,4,4,3,3,4,1,
            1,1,1,1,1,1,1,1,1,1,1,1,1,1,1

    };

    public int set3[]={
            1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
            1,2,3,3,3,3,3,3,3,1,4,4,4,4,4,4,4,1,
            1,3,1,1,3,1,1,1,3,1,4,1,1,1,4,1,4,1,
            1,3,3,3,3,3,3,3,3,3,4,4,4,4,4,4,4,1,
            1,3,1,1,3,1,3,1,1,1,1,1,3,1,4,1,4,1,
            1,3,3,3,3,1,4,4,4,4,4,4,4,1,4,4,4,1,
            1,1,1,1,3,1,1,1,1,1,1,1,1,1,4,1,1,1,
            1,3,4,3,4,3,4,3,4,3,4,3,4,3,4,3,4,1,
            1,3,1,1,3,1,1,1,1,4,1,1,1,3,1,1,3,1,
            1,3,3,3,3,3,3,3,1,4,1,3,3,3,3,3,3,1,
            1,3,1,1,1,1,1,4,4,4,4,4,1,1,1,1,3,1,
            1,4,4,4,4,4,4,4,1,1,1,4,4,4,4,4,4,1,
            1,3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3,1,
            1,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,1,
            1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1

    };

    public int set4[]={
            1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
            1,2,3,4,1,1,3,1,3,4,3,1,3,4,3,4,1,
            1,4,1,4,3,4,3,4,3,1,3,4,3,1,1,4,1,
            1,4,3,4,1,1,3,1,3,4,3,1,3,4,3,4,1,
            1,4,1,4,3,4,3,4,3,1,3,4,3,1,1,4,1,
            1,4,3,4,1,1,3,1,3,1,3,1,3,1,1,4,1,
            1,4,1,4,1,1,3,1,3,1,3,1,3,4,3,4,1,
            1,4,1,4,1,1,3,1,3,1,3,1,3,1,1,4,1,
            1,4,3,4,3,4,3,4,3,4,3,4,3,4,3,4,1,
            1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1


    };

    public int set5[]={
            1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
            1,2,4,4,4,4,4,4,4,4,4,4,4,4,3,1,
            1,3,1,1,1,1,1,1,1,1,1,1,1,1,3,1,
            1,3,4,4,4,4,4,4,4,4,4,4,4,4,3,1,
            1,3,1,1,1,1,1,1,1,1,1,1,1,1,3,1,
            1,3,4,4,4,4,4,4,4,4,4,4,4,4,3,1,
            1,3,1,1,1,1,1,1,1,1,1,1,1,1,3,1,
            1,3,4,4,4,4,4,4,4,4,4,4,4,4,3,1,
            1,3,1,1,1,1,1,1,1,1,1,1,1,1,3,1,
            1,3,4,4,4,4,4,4,4,4,4,4,4,4,3,1,
            1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1


    };
}
