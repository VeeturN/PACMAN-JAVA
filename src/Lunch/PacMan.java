package Lunch;

import javax.swing.*;
import java.awt.*;

public class PacMan extends Characters{
    int clockSec=0;
    int clockMin=0;
    int HP=2;
    public int speed= 2;
    public int addSpeed=1;
    public int direction=0;
    public int score=0;
    public Rectangle bounds=new Rectangle();
    private boolean AMM=false;


    public MAP1 map1;
    public Upgrade upgrade;
    public FinishGame finishGame;

    public PacMan(MAP1 map) {
        pacManIconR = new ImageIcon(image1Pac);
        pacManIconL = new ImageIcon(image2Pac);
        pacManIconD = new ImageIcon(image3Pac);
        pacManIconU = new ImageIcon(image4Pac);
        pacManOpenIconR = new ImageIcon(image11Pac);
        pacManOpenIconL = new ImageIcon(image22Pac);
        pacManOpenIconD = new ImageIcon(image33Pac);
        pacManOpenIconU = new ImageIcon(image44Pac);

        x=50;
        y=50;
        animationCheck();
        clock();

        map1=map;
        upgrade=new Upgrade(this);

        finishGame = new FinishGame();

    }

    public void tick(Ghost g1,Ghost g2,Ghost g3,Ghost g4) {
        draw();
        bounds.setBounds(x,y,50,50);
        map1.Paki.setBounds(x,y,50,50);

        if (right && canMove(x+speed-addSpeed,y)){
            direction=0;
            x+=speed;
            if (up && canMove(x,y-speed+addSpeed)){
                right=false;
                y-=speed;
            }
            if (down && canMove(x,y+speed-addSpeed)){
                right=false;
                y+=speed;
            }
        }
        if (left && canMove(x-speed+addSpeed,y)) {
            direction=1;
            x-=speed;
            if (up && canMove(x,y-speed+addSpeed)){
                left=false;
                y-=speed;
            }
            if (down && canMove(x,y+speed-addSpeed)){
                left=false;
                y+=speed;
            }
        }
        if (up && canMove(x,y-speed+addSpeed)) {
            direction=2;
            y-=speed;
            if (right && canMove(x+speed-addSpeed,y)){
                up=false;
                x+=speed;
            }
            if (left && canMove(x-speed+addSpeed,y)){
                up=false;
                x-=speed;
            }
        }
        if (down && canMove(x,y+speed-addSpeed)) {
            direction=3;
            y+=speed;
            if (right && canMove(x+speed-addSpeed,y)){
                down=false;
                x+=speed;
            }
            if (left && canMove(x-speed+addSpeed,y)){
                down=false;
                x-=speed;
            }
        }

        int xX=0;
        int yY=0;
        int count=0;
        int counter2=0;
        for (int s:map1.set){
            if (s==3){
                if (bounds.intersects(xX+17,yY+17,15,15)) {
                    map1.set[counter2] = 2;
                    score=score+1+upgrade.scoreAdd;
                    map1.labels[counter2].setBackground(Color.BLACK);
                    map1.labels[counter2].setIcon(null);
                }
            }
            if (s==4){
                if (bounds.intersects(xX+17,yY+17,15,15)) {
                    map1.set[counter2] = 2;
                    score=score+(10*upgrade.scoreMultiplier);
                    map1.labels[counter2].setBackground(Color.BLACK);
                    map1.labels[counter2].setIcon(null);
                }
            }
            if (s==5){
                if (bounds.intersects(xX+17,yY+17,15,15)) {
                    map1.set[counter2] = 2;
                    map1.labels[counter2].setBackground(Color.BLACK);
                    map1.labels[counter2].setIcon(null);
                    upgrade.upgradeSpeed();
                }
            }
            if (s==6){
                if (bounds.intersects(xX+17,yY+17,15,15)) {
                    map1.set[counter2] = 2;
                    map1.labels[counter2].setBackground(Color.BLACK);
                    map1.labels[counter2].setIcon(null);
                    upgrade.upgradeGhostSleep(g1, g2, g3, g4);
                }
            }
            if (s==7){
                if (bounds.intersects(xX+17,yY+17,15,15)) {
                    map1.set[counter2] = 2;
                    map1.labels[counter2].setBackground(Color.BLACK);
                    map1.labels[counter2].setIcon(null);
                    upgrade.upgradeScoreMultiplier();
                }
            }
            if (s==8){
                if (bounds.intersects(xX+17,yY+17,15,15)) {
                    map1.set[counter2] = 2;
                    map1.labels[counter2].setBackground(Color.BLACK);
                    map1.labels[counter2].setIcon(null);
                    upgrade.upgradeHP(this);
                }
            }
            if (s==9){
                if (bounds.intersects(xX+17,yY+17,15,15)) {
                    map1.set[counter2] = 2;
                    map1.labels[counter2].setBackground(Color.BLACK);
                    map1.labels[counter2].setIcon(null);
                    upgrade.upgradeGhostSpawn(g1,g2,g3,g4);
                }
            }
            xX+=50;
            count++;
            counter2++;
            if (count==map1.blockSizeY){
                yY+=50;
                xX=0;
                count=0;
            }
        }

        infoLabelUptade();
    }

    public boolean canMove(int nextX,int nextY){
        Rectangle bounds=new Rectangle(nextX,nextY,50,50);

        int xX=0;
        int yY=0;
        int count=0;
        for (int s:map1.set){
            if (s==1){
                if (bounds.intersects(xX,yY,50,50)) {
                    return false;
                }
            }
            xX+=50;
            count++;
            if (count==map1.blockSizeY){
                yY+=50;
                xX=0;
                count=0;
            }
        }
        return true;
    }

    public void animationCheck(){
        new Thread(() -> {
            while (Lvl1.isRunning){
                try {
                    if (AMM){
                        AMM=false;
                    }else {
                        AMM=true;
                    }
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void draw() {

        if (AMM){
            if (direction==0){
                map1.Paki.setIcon(pacManIconR);
            }
            if (direction==1){
                map1.Paki.setIcon(pacManIconL);
            }
            if (direction==2){
                map1.Paki.setIcon(pacManIconU);
            }
            if (direction==3){
                map1.Paki.setIcon(pacManIconD);
            }
        }else {
            if (direction==0){
                map1.Paki.setIcon(pacManOpenIconR);
            }
            if (direction==1){
                map1.Paki.setIcon(pacManOpenIconL);
            }
            if (direction==2){
                map1.Paki.setIcon(pacManOpenIconU);
            }
            if (direction==3){
                map1.Paki.setIcon(pacManOpenIconD);
            }
        }
    }

    public void infoLabelUptade(){
        switch (HP) {
            case 1:
                map1.labelH1.setIcon(map1.heart);
                map1.labelH2.setIcon(null);
                map1.labelH3.setIcon(null);
                map1.labelH4.setIcon(null);
                break;
            case 2:
                map1.labelH1.setIcon(map1.heart);
                map1.labelH2.setIcon(map1.heart);
                map1.labelH3.setIcon(null);
                map1.labelH4.setIcon(null);
                break;
            case 3:
                map1.labelH1.setIcon(map1.heart);
                map1.labelH2.setIcon(map1.heart);
                map1.labelH3.setIcon(map1.heart);
                map1.labelH4.setIcon(null);

                break;
            case 4:
                map1.labelH1.setIcon(map1.heart);
                map1.labelH2.setIcon(map1.heart);
                map1.labelH3.setIcon(map1.heart);
                map1.labelH4.setIcon(map1.heart);
                break;
            default:
                map1.labelH1.setIcon(map1.heart);
                map1.labelH2.setIcon(map1.heart);
                map1.labelH3.setIcon(map1.heart);
                map1.labelH4.setIcon(map1.heart);
                break;
        }
        map1.labelH0.setIcon(map1.pacManH);

        map1.labelT1.setText("TIME: " + clockMin + ":" + clockSec);
        map1.labelS1.setText("SCORE: " + score);

    }

    public void clock(){
        new Thread(() -> {
            while (Lvl1.isRunning) {
                try {
                    if (clockSec==59){
                        clockSec=0;
                        clockMin++;
                    }
                    clockSec++;
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
