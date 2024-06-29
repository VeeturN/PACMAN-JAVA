package Lunch;

import javax.swing.*;
import java.awt.*;

public class Ghost extends Characters{
    public int speed= 2;
    boolean sleep=true;
    public PacMan mrPacMan;
    private int character=0;
    public MAP1 map1;
    public Ghost(MAP1 map1,int PosX, int PosY,PacMan pacMan,int Character){
        fruit1 = new ImageIcon(image5);
        fruit2 = new ImageIcon(image6);
        fruit3 = new ImageIcon(image7);
        fruit4 = new ImageIcon(image8);
        fruit5 = new ImageIcon(image9);

        ghostIcon1 = new ImageIcon(image1);
        ghostIcon2 = new ImageIcon(image2);
        ghostIcon3 = new ImageIcon(image3);
        ghostIcon4 = new ImageIcon(image4);


        this.map1=map1;
        x=PosX;
        y=PosY;
        randomMove();
        mrPacMan=pacMan;
        character=Character;

        draw();
        upgrade();
    }
    public void randomMove(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (Lvl1.isRunning) {
                    try {
                        int direction = (int) (Math.random() * 4);
                        if (direction == 0){
                            right=true;
                            left=false;
                            up=true;
                            down=false;
                        }
                        if (direction == 1){
                            right=true;
                            left=false;
                            up=false;
                            down=true;
                        }
                        if (direction == 2){
                            right=false;
                            left=true;
                            up=true;
                            down=false;
                        }
                        if (direction == 3){
                            right=false;
                            left=true;
                            up=false;
                            down=true;
                        }

                        //System.out.println("Direction: " + direction);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public void tick() {
        bounds.setBounds(x,y,50,50);
        if (sleep) {
            if (right && canMove(x + speed, y)) {
                x += speed;
                if (up && canMove(x, y - speed)) {
                    right = false;
                    y -= speed;
                }
                if (down && canMove(x, y + speed)) {
                    right = false;
                    y += speed;
                }
            }
            if (left && canMove(x - speed, y)) {
                x -= speed;
                if (up && canMove(x, y - speed)) {
                    left = false;
                    y -= speed;
                }
                if (down && canMove(x, y + speed)) {
                    left = false;
                    y += speed;
                }
            }
            if (up && canMove(x, y - speed)) {
                y -= speed;
                if (right && canMove(x + speed, y)) {
                    up = false;
                    x += speed;
                }
                if (left && canMove(x - speed, y)) {
                    up = false;
                    x -= speed;
                }
            }
            if (down && canMove(x, y + speed)) {
                y += speed;
                if (right && canMove(x + speed, y)) {
                    down = false;
                    x += speed;
                }
                if (left && canMove(x - speed, y)) {
                    down = false;
                    x -= speed;
                }
            }

            if (bounds.intersects(mrPacMan.bounds)) {
                mrPacMan.HP -= 1;
                mrPacMan.x=50;
                mrPacMan.y=50;
                x = 650;
                y = 50;
                System.out.println("Collision");
            }
        }
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
            if (count== map1.blockSizeY){
                yY+=50;
                xX=0;
                count=0;
            }
        }
        return true;
    }

    public void upgrade(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (Lvl1.isRunning) {
                    try {
                        int luck=(int) (Math.random() * 4);
                        int upgrade=(int) (Math.random() * 5);
                        if (luck==0){
                            int xX=0;
                            int yY=0;
                            int count=0;
                            int counter2=0;
                            for (int s:map1.set){
                                if (upgrade==0) {
                                    if (bounds.intersects(xX + 25, yY + 25, 1, 1)) {
                                        map1.set[counter2] = 5;
                                        map1.labels[counter2].setBackground(Color.BLACK);
                                        map1.labels[counter2].setIcon(fruit1);
                                    }
                                }
                                if (upgrade==1) {
                                    if (bounds.intersects(xX + 25, yY + 25, 1, 1)) {
                                        map1.set[counter2] = 6;
                                        map1.labels[counter2].setBackground(Color.BLACK);
                                        map1.labels[counter2].setIcon(fruit2);
                                    }
                                }
                                if (upgrade==2) {
                                    if (bounds.intersects(xX + 25, yY + 25, 1, 1)) {
                                        map1.set[counter2] = 7;
                                        map1.labels[counter2].setBackground(Color.BLACK);
                                        map1.labels[counter2].setIcon(fruit3);
                                    }
                                }
                                if (upgrade==3) {
                                    if (bounds.intersects(xX + 25, yY + 25, 1, 1)) {
                                        map1.set[counter2] = 8;
                                        map1.labels[counter2].setBackground(Color.BLACK);
                                        map1.labels[counter2].setIcon(fruit4);
                                    }
                                }
                                if (upgrade==4) {
                                    if (bounds.intersects(xX + 25, yY + 25, 1, 1)) {
                                        map1.set[counter2] = 9;
                                        map1.labels[counter2].setBackground(Color.BLACK);
                                        map1.labels[counter2].setIcon(fruit5);
                                    }
                                }
                                xX+=50;
                                count++;
                                counter2++;
                                if (count== map1.blockSizeY){
                                    yY+=50;
                                    xX=0;
                                    count=0;
                                }
                            }
                        }
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public void draw() {
        if (character==1){
            map1.ghost1.setIcon(ghostIcon1);
        }
        if (character==2){
            map1.ghost2.setIcon(ghostIcon2);
        }
        if (character==3){
            map1.ghost3.setIcon(ghostIcon3);
        }
        if (character==4){
            map1.ghost4.setIcon(ghostIcon4);
        }
    }
}
