package Lunch;

import javax.swing.*;
public class Main extends Thread{
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindow4();
            }
        });
    }
}