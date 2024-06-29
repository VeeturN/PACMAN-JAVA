package Lunch;

import org.w3c.dom.css.Counter;

import javax.swing.*;
import javax.swing.plaf.PanelUI;
import java.awt.*;


public class MAP1 extends SelectMap{
    int blockSizeY;
    int windowStaticSizeX;
    int windowStaticSizeY;
    int size;
    public JLabel[] labels = new JLabel[280];
    public JLabel labelH0 = new JLabel();
    public JLabel labelH1 = new JLabel();
    public JLabel labelH2 = new JLabel();
    public JLabel labelH3 = new JLabel();
    public JLabel labelH4 = new JLabel();
    public JLabel labelT1 = new JLabel();
    public JLabel labelS1 = new JLabel();

    public JPanel panelMain=new JPanel();
    public JPanel panelMain2=new JPanel();
    public JLabel infoPanel=new JLabel();

    public JLabel Paki=new JLabel();
    public JLabel ghost1=new JLabel();
    public JLabel ghost2=new JLabel();
    public JLabel ghost3=new JLabel();
    public JLabel ghost4=new JLabel();

    public int[] set;
    int maps;
    public MAP1(int maps,int windowX,int windowY) {
        for (int i=0;i<labels.length;i++){
            labels[i]=new JLabel();
        }
        this.maps=maps;
        this.windowStaticSizeX=windowX;
        this.windowStaticSizeY=windowY;
        chooseMap();


        smallCoin = new ImageIcon(image1);
        bigCoin =new ImageIcon(image2);
        pacManH=new ImageIcon(image3);
        heart=new ImageIcon(image4);


        panelMain.setBounds(0,0,windowStaticSizeX,windowStaticSizeY);
        panelMain2.setBounds(0,0,windowStaticSizeX,windowStaticSizeY);

        panelMain.setLayout(null);
        panelMain.setBackground(Color.BLUE);
        panelMain.setVisible(true);

        panelMain2.setLayout(null);
        panelMain2.setBackground(Color.BLUE);
        panelMain2.setVisible(true);


        paintMap();
        infoPanel.setBackground(Color.BLUE);
        infoPanel.setLayout(null);
        infoPanel.setVisible(true);
        infoPanel.setOpaque(true);
        infoPanel.setBounds(0,windowStaticSizeY-120,windowStaticSizeX,100);
        labelH0.setBounds(5,10,60,60);
        labelH1.setBounds(60,10,60,60);
        labelH2.setBounds(110,10,60,60);
        labelH3.setBounds(160,10,60,60);
        labelH4.setBounds(210,10,60,60);

        labelT1.setBounds(270,10,220,60);
        labelT1.setFont(new Font("MV Boli", Font.PLAIN, 35));
        labelT1.setHorizontalTextPosition(JLabel.CENTER);
        labelT1.setVerticalTextPosition(JLabel.CENTER);
        labelT1.setForeground(Color.BLACK);

        labelS1.setBounds(480,10,320,60);
        labelS1.setFont(new Font("MV Boli", Font.PLAIN, 35));
        labelS1.setHorizontalTextPosition(JLabel.CENTER);
        labelS1.setVerticalTextPosition(JLabel.CENTER);
        labelS1.setForeground(Color.BLACK);



        infoPanel.add(labelH0);
        infoPanel.add(labelH1);
        infoPanel.add(labelH2);
        infoPanel.add(labelH3);
        infoPanel.add(labelH4);
        infoPanel.add(labelT1);
        infoPanel.add(labelS1);
        panelMain2.add(infoPanel);


        try {
            panelMain.setComponentZOrder(panelMain2, 0);
            panelMain.setComponentZOrder(Paki, 1);
            panelMain.setComponentZOrder(ghost1,2);
            panelMain.setComponentZOrder(ghost2,2);
            panelMain.setComponentZOrder(ghost3,2);
            panelMain.setComponentZOrder(ghost4,2);
        }catch (Exception e) {
            System.out.println("ERROR");
        }

        panelMain.add(panelMain2);
    }

    public void chooseMap(){
        switch (maps){
            case 1:
                set=set1;
                blockSizeY=15;
                break;
            case 2:
                set=set2;
                blockSizeY=15;
                break;
            case 3:
                set=set3;
                blockSizeY=18;
                break;
            case 4:
                set=set4;
                blockSizeY=17;
                break;
            case 5:
                set=set5;
                blockSizeY=16;
                break;
            default:
                System.out.println("ERROR");
        }
    }


    public void paintMap(){
        int xX=0;
        int yY=0;
        int counter=0;
        int count=0;

        for (int s:set){
            if (s==1){
                labels[counter].setBackground(Color.BLUE);
                labels[counter].setBounds(xX,yY,50,50);
                labels[counter].setOpaque(true);
                panelMain2.add(labels[counter]);
                counter++;
            }
            if (s==2){
                labels[counter].setBackground(Color.BLACK);
                labels[counter].setBounds(xX,yY,50,50);
                labels[counter].setOpaque(true);
                panelMain2.add(labels[counter]);
                counter++;
            }
            if (s==3){
                labels[counter].setBackground(Color.BLACK);
                labels[counter].setBounds(xX,yY,50,50);
                labels[counter].setOpaque(true);
                labels[counter].setIcon(smallCoin);
                panelMain2.add(labels[counter]);
                counter++;
            }
            if (s==4){
                labels[counter].setBackground(Color.BLACK);
                labels[counter].setBounds(xX,yY,50,50);
                labels[counter].setOpaque(true);
                labels[counter].setIcon(bigCoin);
                panelMain2.add(labels[counter]);
                counter++;
            }
            xX+=50;
            count++;
            if (count==blockSizeY){
                yY+=50;
                xX=0;
                count=0;
            }
        }
    }


    public void draw(JFrame frame) {
//        size = Math.min(frame.getWidth(), frame.getHeight());
//        panelMain.setBounds(0, 0, size, size);
//        panelMain2.setBounds(20,20,size-100,size-100);
        frame.add(panelMain);
    }

    public boolean getEnableScore(){
        for (int x:set){
            if (x==3 || x==4){
                return false;
            }
        }
        return true;
    }
}
