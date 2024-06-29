package Lunch;

import javax.swing.*;
import java.awt.*;

public abstract class Images {
    ImageIcon ghostIcon1 = new ImageIcon("Asset/blueGhost.png");
    ImageIcon ghostIcon2 = new ImageIcon("Asset/greenGhost.png");
    ImageIcon ghostIcon3 = new ImageIcon("Asset/orangeGhost.png");
    ImageIcon ghostIcon4 = new ImageIcon("Asset/redGhost.png");

    ImageIcon fruit1 = new ImageIcon("Asset/fruit1.png");
    ImageIcon fruit2 = new ImageIcon("Asset/fruit2.png");
    ImageIcon fruit3 = new ImageIcon("Asset/fruit3.png");
    ImageIcon fruit4 = new ImageIcon("Asset/fruit4.png");
    ImageIcon fruit5 = new ImageIcon("Asset/fruit5.png");
    Image image5 = fruit1.getImage().getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
    Image image6 = fruit2.getImage().getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
    Image image7 = fruit3.getImage().getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
    Image image8 = fruit4.getImage().getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
    Image image9 = fruit5.getImage().getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);



    Image image1 = ghostIcon1.getImage().getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
    Image image2 = ghostIcon2.getImage().getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
    Image image3 = ghostIcon3.getImage().getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
    Image image4 = ghostIcon4.getImage().getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);


    ImageIcon pacManIconR = new ImageIcon("Asset/PacManR.png");
    ImageIcon pacManIconL = new ImageIcon("Asset/PacManL.png");
    ImageIcon pacManIconD = new ImageIcon("Asset/PacManD.png");
    ImageIcon pacManIconU = new ImageIcon("Asset/PacManU.png");
    ImageIcon pacManOpenIconR = new ImageIcon("Asset/PacManOpenR.png");
    ImageIcon pacManOpenIconL = new ImageIcon("Asset/PacManOpenL.png");
    ImageIcon pacManOpenIconD = new ImageIcon("Asset/PacManOpenD.png");
    ImageIcon pacManOpenIconU = new ImageIcon("Asset/PacManOpenU.png");

    Image image1Pac = pacManIconR.getImage().getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
    Image image2Pac = pacManIconL.getImage().getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
    Image image3Pac = pacManIconD.getImage().getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
    Image image4Pac = pacManIconU.getImage().getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
    Image image11Pac = pacManOpenIconR.getImage().getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
    Image image22Pac = pacManOpenIconL.getImage().getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
    Image image33Pac = pacManOpenIconD.getImage().getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
    Image image44Pac = pacManOpenIconU.getImage().getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
}
