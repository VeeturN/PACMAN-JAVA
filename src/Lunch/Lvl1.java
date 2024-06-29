package Lunch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Lvl1 extends JPanel implements Runnable {
    static boolean isRunning = true;
    JFrame windowLvl1 = new JFrame();
    private PacMan pacMan;
    private Ghost ghost1;
    private Ghost ghost2;
    private Ghost ghost3;
    private Ghost ghost4;


    private Thread gameThread;
    private MAP1 map1;
    private FinishGame finishGame = new FinishGame();


    public Lvl1(int maps,int sizeX,int sizeY, int GposX, int GposY, int GposX2, int GposY2, int GposX3, int GposY3, int GposX4, int GposY4) {
        map1 = new MAP1(maps, sizeX, sizeY);
        pacMan = new PacMan(map1);
        ghost1 = new Ghost(map1,GposX, GposY, pacMan, 1);
        ghost2 = new Ghost(map1,GposX2, GposY2, pacMan, 2);
        ghost3 = new Ghost(map1,GposX3, GposY3, pacMan, 3);
        ghost4 = new Ghost(map1,GposX4, GposY4, pacMan, 4);

        windowLvl1.setTitle("PacMAN");
        windowLvl1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windowLvl1.setSize(sizeX, sizeY);
        windowLvl1.setLocationRelativeTo(null);
        windowLvl1.setVisible(true);


        this.setBackground(Color.BLACK);
        windowLvl1.add(this);

        windowLvl1.setFocusable(true);
        windowLvl1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key==KeyEvent.VK_D){
                    pacMan.right=true;
                }else if (key==KeyEvent.VK_A) {
                    pacMan.right = false;
                }
                if (key==KeyEvent.VK_A){
                    pacMan.left=true;
                } else if (key==KeyEvent.VK_D){
                    pacMan.left=false;
                }
                if (key==KeyEvent.VK_W){
                    pacMan.up=true;
                } else if (key==KeyEvent.VK_S){
                    pacMan.up=false;
                }
                if (key==KeyEvent.VK_S){
                    pacMan.down=true;
                } else if (key==KeyEvent.VK_W) {
                    pacMan.down=false;
                }
                if (key==KeyEvent.VK_ESCAPE){
                    windowLvl1.dispose();
                    isRunning=false;
                    new MainWindow4();
                }
            }
        });

        gameThread = new Thread(this);
        gameThread.start();
    }





    @Override
    public void run() {
        while (isRunning){
            pacMan.tick(ghost1,ghost2,ghost3,ghost4);
            ghost1.tick();
            ghost2.tick();
            ghost3.tick();
            ghost4.tick();

            map1.ghost1.setBounds(ghost1.x,ghost1.y,50,50);
            map1.ghost2.setBounds(ghost2.x,ghost2.y,50,50);
            map1.ghost3.setBounds(ghost3.x,ghost3.y,50,50);
            map1.ghost4.setBounds(ghost4.x,ghost4.y,50,50);

            map1.draw(windowLvl1);
            windowLvl1.repaint();
            if (pacMan.HP==0 || map1.getEnableScore()){
                isRunning=false;
                finishGame.endGame(pacMan.score,windowLvl1);
            }
            try {
                Thread.sleep(10);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
