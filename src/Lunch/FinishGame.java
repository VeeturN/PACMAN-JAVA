package Lunch;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinishGame implements ActionListener {
    private int score;
    JFrame scoreWin = new JFrame();
    JButton button = new JButton("Submit");
    JTextField textField = new JTextField("Enter your name");
    FinishGame(){

    }
    public void endGame(int score, JFrame windowLvl1){
        winGame(score);
        windowLvl1.dispose();
    }
    public void winGame(int score){
        this.score= score;
        scoreWin.setTitle("PacMAN");
        scoreWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        scoreWin.setSize(766, 870);
        scoreWin.setLocationRelativeTo(null);
        scoreWin.setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.BLACK);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        panel2.setBackground(Color.BLACK);

        JLabel label = new JLabel("<html>You Win! <br> Your Score: " + score+"</html>");
        label.setFont(new Font("Arial", Font.PLAIN, 50));
        label.setForeground(Color.WHITE);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setBorder(new EmptyBorder(25, 25, 10, 10));
        panel.add(label, BorderLayout.CENTER);



        JLabel label2 = new JLabel();
        JLabel label3 = new JLabel();
        JLabel label4 = new JLabel();
        JLabel label5 = new JLabel();

        label2.setPreferredSize(new Dimension(50, 50));
        label3.setPreferredSize(new Dimension(50, 50));
        label4.setPreferredSize(new Dimension(50, 50));
        label5.setPreferredSize(new Dimension(50, 50));

        label2.setBackground(Color.BLUE);
        label3.setBackground(Color.BLUE);
        label4.setBackground(Color.BLUE);
        label5.setBackground(Color.BLUE);

        label2.setOpaque(true);
        label3.setOpaque(true);
        label4.setOpaque(true);
        label5.setOpaque(true);

        panel.add(label2, BorderLayout.WEST);
        panel.add(label3, BorderLayout.EAST);
        panel.add(label4, BorderLayout.NORTH);
        panel.add(label5, BorderLayout.SOUTH);

        panel.add(panel2, BorderLayout.CENTER);
        panel2.add(label, BorderLayout.NORTH);

        textField.setBackground(Color.YELLOW);
        textField.setFont(new Font("Arial", Font.PLAIN, 30));
        textField.setPreferredSize(new Dimension(200, 50));
        textField.setBorder(new LineBorder(Color.BLACK, 50));
        panel2.add(textField, BorderLayout.CENTER);
        button.setFont(new Font("Arial", Font.PLAIN, 30));
        button.setPreferredSize(new Dimension(200, 50));
        button.addActionListener(this);
        button.setBackground(Color.YELLOW);
        button.setBorder(new LineBorder(Color.BLACK, 8));
        button.setFocusable(false);
        panel2.add(button, BorderLayout.SOUTH);

        scoreWin.add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            textField.getText();
            MainWindow4.scoreList.add(new Score(textField.getText(), score));
            scoreWin.dispose();
            new MainWindow4();
        }
    }
}
