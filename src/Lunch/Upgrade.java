package Lunch;

import java.awt.*;

// WIŚNIA - > SPEED
//TRUSKAWKA -> GHOSTS SLEEP
//POMARANCZOWE JABLKO ? -> SCORE MULTIPLIER
//JABŁKO -> HP
//ZIELONE COS  -> GHOSTS SPAWN

public class Upgrade {
    PacMan pacMan;
    int scoreMultiplier=1;
    int scoreAdd=0;
    Upgrade(PacMan pacMan) {
        this.pacMan = pacMan;
    }
    public void upgradeSpeed(){

        new Thread(() -> {
            try {
                pacMan.speed+=2;
                Thread.sleep(2000);
                pacMan.speed-=2;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void upgradeGhostSleep(Ghost g1,Ghost g2,Ghost g3,Ghost g4){

        new Thread(() -> {
            try {
                g1.sleep=false;
                g2.sleep=false;
                g3.sleep=false;
                g4.sleep=false;
                Thread.sleep(5000);
                g1.sleep=true;
                g2.sleep=true;
                g3.sleep=true;
                g4.sleep=true;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
    public void upgradeScoreMultiplier(){

        new Thread(() -> {
            try {
                scoreMultiplier=2;
                scoreAdd=1;
                Thread.sleep(5000);
                scoreMultiplier=1;
                scoreAdd=0;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void upgradeHP(PacMan pacMan) {
        pacMan.HP+=1;
    }

    public void upgradeGhostSpawn(Ghost g1,Ghost g2,Ghost g3,Ghost g4){
        g1.x=650;
        g1.y=50;
        g2.x=650;
        g2.y=50;
        g3.x=650;
        g3.y=50;
        g4.x=650;
        g4.y=50;
    }
}
