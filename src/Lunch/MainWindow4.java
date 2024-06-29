package Lunch;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

public class MainWindow4 implements ActionListener {
    private JFrame window;
    private JLabel label;
    private JPanel mainPanel;
    private JPanel panel1;
    private JPanel panelHighScore;
    private JPanel panelNewGame;
    private JPanel panelNewGameR;
    private JPanel panelNewGameL;
    private JPanel panelNewGameT;
    private JPanel panelNewGameB;
    private JPanel panelNewGameC;
    private JPanel panelNewGameC1;
    private JPanel panelNewGameC2;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton buttonL1;
    private JButton buttonL2;
    private JButton buttonL3;
    private JButton buttonL4;
    private JButton buttonL5;
    private JButton EXIT1;
    private JButton EXIT2;
    private CardLayout cardLayout;

    static ArrayList<Score> scoreList = new ArrayList<>();

    static boolean Update=true;

    public MainWindow4() {
        show();
        panels();
        labels();
        buttons();
    }
    public void show(){
        window =new JFrame();
        window.setTitle("PacMAN");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(750,750);
        window.setLayout(new BorderLayout());
        cardLayout=new CardLayout();
        mainPanel=new JPanel(cardLayout);
        window.add(mainPanel);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
    public void panels(){
        //LOBBY
        panel1=new JPanel();
        panel1.setBackground(Color.BLUE);
        panel1.setLayout(new GridLayout(4,1,30,30));
        panel1.setBorder(new EmptyBorder(30,30,30,30));
        mainPanel.add(panel1);

        //SCORES
        panelHighScore=new JPanel();
        panelHighScore.setBackground(Color.BLUE);
        panelHighScore.setLayout(new BorderLayout());



        //NEW GAME
        panelNewGame=new JPanel();
        panelNewGame.setBackground(Color.BLUE);
        panelNewGame.setLayout(new BorderLayout());
        panelNewGame.setBorder(new LineBorder(Color.BLACK,5));

        panelNewGameL=new JPanel();
        panelNewGameR=new JPanel();
        panelNewGameB=new JPanel();
        panelNewGameT=new JPanel();
        panelNewGameC=new JPanel();
        panelNewGameC.setLayout(new BorderLayout());
        panelNewGameC.setBorder(new LineBorder(Color.BLACK,5));

        panelNewGameL.setBackground(Color.YELLOW);
        panelNewGameR.setBackground(Color.YELLOW);
        panelNewGameB.setBackground(Color.YELLOW);
        panelNewGameT.setBackground(Color.YELLOW);
        panelNewGameC.setBackground(Color.BLUE);

        panelNewGameL.setPreferredSize(new Dimension(100,50));
        panelNewGameR.setPreferredSize(new Dimension(100,50));
        panelNewGameB.setPreferredSize(new Dimension(50,50));
        panelNewGameT.setPreferredSize(new Dimension(50,50));


        panelNewGame.add(panelNewGameL,BorderLayout.EAST);
        panelNewGame.add(panelNewGameR,BorderLayout.WEST);
        panelNewGame.add(panelNewGameB,BorderLayout.SOUTH);
        panelNewGame.add(panelNewGameT,BorderLayout.NORTH);
        panelNewGame.add(panelNewGameC,BorderLayout.CENTER);


        panelNewGameC1=new JPanel();
        panelNewGameC1.setBackground(Color.BLUE);
        panelNewGameC1.setLayout(new BorderLayout());
        panelNewGameC2=new JPanel();
        panelNewGameC2.setLayout(new BorderLayout());
        panelNewGameC2.setBackground(Color.BLUE);
        panelNewGameC2.setLayout(new GridLayout(6,1,30,30));
        panelNewGameC2.setBorder(new EmptyBorder(30,30,30,30));

        panelNewGameC.add(panelNewGameC1,BorderLayout.NORTH);
        panelNewGameC.add(panelNewGameC2,BorderLayout.CENTER);


        mainPanel.add(panel1,"MainPanel");
        mainPanel.add(panelHighScore,"HighScorePanel");
        mainPanel.add(panelNewGame,"NewGamePanel");

    }
    public void buttons(){
        button1=new JButton("New Game");
        button1.setBackground(Color.YELLOW);
        button1.setForeground(Color.BLACK);
        button1.setFocusable(false);
        button1.addActionListener(this);
        panel1.add(button1);

        button2=new JButton("High Score");
        button2.setBackground(Color.YELLOW);
        button2.setForeground(Color.BLACK);
        button2.setFocusable(false);
        button2.addActionListener(this);
        panel1.add(button2);

        button3=new JButton("Exit");
        button3.setBackground(Color.YELLOW);
        button3.setForeground(Color.BLACK);
        button3.setFocusable(false);
        button3.addActionListener(this);
        panel1.add(button3);

        buttonL1=new JButton("LVL 1");
        buttonL1.setBackground(Color.YELLOW);
        buttonL1.setForeground(Color.BLACK);
        buttonL1.setFocusable(false);
        buttonL1.addActionListener(this);
        panelNewGameC2.add(buttonL1);

        buttonL2=new JButton("LVL 2");
        buttonL2.setBackground(Color.YELLOW);
        buttonL2.setForeground(Color.BLACK);
        buttonL2.setFocusable(false);
        buttonL2.addActionListener(this);
        panelNewGameC2.add(buttonL2);

        buttonL3=new JButton("LVL 3");
        buttonL3.setBackground(Color.YELLOW);
        buttonL3.setForeground(Color.BLACK);
        buttonL3.setFocusable(false);
        buttonL3.addActionListener(this);
        panelNewGameC2.add(buttonL3);

        buttonL4=new JButton("LVL 4");
        buttonL4.setBackground(Color.YELLOW);
        buttonL4.setForeground(Color.BLACK);
        buttonL4.setFocusable(false);
        buttonL4.addActionListener(this);
        panelNewGameC2.add(buttonL4);

        buttonL5=new JButton("LVL 5");
        buttonL5.setBackground(Color.YELLOW);
        buttonL5.setForeground(Color.BLACK);
        buttonL5.setFocusable(false);
        buttonL5.addActionListener(this);
        panelNewGameC2.add(buttonL5);

        EXIT1=new JButton("EXIT");
        EXIT1.setBackground(Color.YELLOW);
        EXIT1.setForeground(Color.BLACK);
        EXIT1.setFocusable(false);
        EXIT1.addActionListener(this);
        panelNewGameC2.add(EXIT1);

        EXIT2=new JButton("EXIT");
        EXIT2.setFont(new Font("MV Boli",Font.PLAIN,35));
        EXIT2.setPreferredSize(new Dimension(100,60));
        EXIT2.setBackground(Color.BLUE);
        EXIT2.setForeground(Color.BLACK);
        EXIT2.setFocusable(false);
        EXIT2.addActionListener(this);
        panelHighScore.add(EXIT2, BorderLayout.SOUTH);
    }
    public void labels(){
        //LOBBY

        label=new JLabel();
        label.setText("<html>PACMAN 2.0 <br> Made by Dawid</html>");
        label.setForeground(Color.YELLOW);
        label.setFont(new Font("MV Boli",Font.PLAIN,35));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        panel1.add(label);

        //SCORES
        JPanel p1 = new JPanel();
        p1.setLayout(new BorderLayout());
        p1.setBorder(new EmptyBorder(30,30,30,30));
        p1.setBackground(Color.YELLOW);

        JLabel highScoreLabel = new JLabel("^^ Scores ^^");
        highScoreLabel.setForeground(Color.BLUE);
        highScoreLabel.setFont(new Font("MV Boli", Font.PLAIN, 35));
        highScoreLabel.setHorizontalAlignment(JLabel.CENTER);
        p1.add(highScoreLabel, BorderLayout.NORTH);



        if (Update==true) {
            try {
                FileInputStream fileInputStream = new FileInputStream("score.txt");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

                ArrayList<Score> scoress = (ArrayList<Score>) objectInputStream.readObject();
                objectInputStream.close();
                for (Score x : scoress) {
                    scoreList.add(x);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            Update=false;
        }

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("score.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(scoreList);
            objectOutputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        Collections.sort(scoreList);

        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Score score : scoreList) {
            listModel.addElement(score.toString());
        }


        JList<String> list = new JList<>(listModel);
        list.setFont(new Font("MV Boli", Font.PLAIN, 35));
        list.setBorder(new LineBorder(Color.BLUE,10));
        list.setBackground(Color.YELLOW);
        list.setForeground(Color.BLUE);
        list.setFocusable(false);


        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setBorder(new EmptyBorder(30,30,30,30));

        scrollPane.setBackground(Color.YELLOW);
        p1.add(scrollPane, BorderLayout.CENTER);
        panelHighScore.add(p1, BorderLayout.CENTER);

        JLabel highScoreLabel1 = new JLabel();
        JLabel highScoreLabel2 = new JLabel();
        JLabel highScoreLabel3 = new JLabel();
        JLabel highScoreLabel4 = new JLabel();

        highScoreLabel1.setOpaque(true);
        highScoreLabel2.setOpaque(true);
        highScoreLabel3.setOpaque(true);
        highScoreLabel4.setOpaque(true);

        highScoreLabel1.setPreferredSize(new Dimension(100,100));
        highScoreLabel2.setPreferredSize(new Dimension(100,100));
        highScoreLabel3.setPreferredSize(new Dimension(50,100));
        highScoreLabel4.setPreferredSize(new Dimension(50,100));

        highScoreLabel1.setBackground(Color.BLUE);
        highScoreLabel2.setBackground(Color.BLUE);
        highScoreLabel3.setBackground(Color.BLUE);
        highScoreLabel4.setBackground(Color.BLUE);

        panelHighScore.add(highScoreLabel1, BorderLayout.NORTH);
        //panelHighScore.add(highScoreLabel2, BorderLayout.SOUTH);
        panelHighScore.add(highScoreLabel3, BorderLayout.EAST);
        panelHighScore.add(highScoreLabel4, BorderLayout.WEST);


        //NEW GAME
        JLabel NewGameLabel = new JLabel("Choose LVL");
        NewGameLabel.setForeground(Color.BLACK);
        NewGameLabel.setFont(new Font("MV Boli", Font.PLAIN, 35));
        //NewGameLabel.setOpaque(true);
        NewGameLabel.setHorizontalAlignment(JLabel.CENTER);

        panelNewGameC1.add(NewGameLabel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==button1){
            cardLayout.show(mainPanel,"NewGamePanel");

        }
        if (e.getSource()==button2){
            cardLayout.show(mainPanel,"HighScorePanel");
        }
        if (e.getSource()==button3){
            window.dispose();
        }
        if (e.getSource()==buttonL1){
            Lvl1.isRunning=true;
            new Lvl1(1,766,860,650,50,650,50,650,650,650,650);
            window.dispose();
        }
        if (e.getSource()==buttonL2){
            Lvl1.isRunning=true;
            new Lvl1(2,766,660,650,50,650,50,650,50,650,50);
            window.dispose();
        }
        if (e.getSource()==buttonL3){
            Lvl1.isRunning=true;
            new Lvl1(3,910,860,450,400,450,400,450,400,450,400);
            window.dispose();
        }
        if (e.getSource()==buttonL4){
            Lvl1.isRunning=true;
            new Lvl1(4,865,600,650,50,650,50,650,50,650,50);
            window.dispose();
        }
        if (e.getSource()==buttonL5){
            Lvl1.isRunning=true;
            new Lvl1(5,816,670,650,50,650,50,650,50,650,50);
            window.dispose();
        }
        if (e.getSource()==EXIT1){
            cardLayout.show(mainPanel,"MainPanel");
        }
        if (e.getSource()==EXIT2){
            cardLayout.show(mainPanel,"MainPanel");
        }
    }
}
