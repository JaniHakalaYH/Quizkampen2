package Client;

import Server.Question;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizFrames extends JFrame implements ActionListener {
    JPanel categoryPanel;
    JPanel questionPanel;
    JPanel scorePanel;
    JLabel label1 = new JLabel();
    JButton category1 = new JButton("category");
    JButton category2 = new JButton("category");
    JButton category3 = new JButton("category");
    JButton category4 = new JButton("category");
    JButton category5 = new JButton("category");
    JButton category6 = new JButton("category");
    JButton svar1 = new JButton("Svar");
    JButton svar2 = new JButton("Svar");
    JButton svar3 = new JButton("Svar");
    JButton svar4 = new JButton("Svar");
    JLabel score1;
    JLabel score2;
    JTextField changeName = new JTextField("");

    public QuizFrames(){
        setSize(300,300);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void categoryFrame(){
        categoryPanel = new JPanel();
        JPanel gridWithCategories = new JPanel();
        add(categoryPanel);

        categoryPanel.setLayout(new BorderLayout());
        gridWithCategories.setLayout(new GridLayout(3,2));
        categoryPanel.add(gridWithCategories, BorderLayout.CENTER);
        categoryPanel.add(label1, BorderLayout.NORTH);
        gridWithCategories.add(category1);
        gridWithCategories.add(category2);
        gridWithCategories.add(category3);
        gridWithCategories.add(category4);
        gridWithCategories.add(category5);
        gridWithCategories.add(category6);

        label1.setText("Välj en kategori");

        category1.addActionListener(this);
        category2.addActionListener(this);
        category3.addActionListener(this);
        category4.addActionListener(this);
        category5.addActionListener(this);
        category6.addActionListener(this);
    }
    public void questionFrame(){
        questionPanel = new JPanel();
        JPanel panel3 = new JPanel();
        add(questionPanel);

        questionPanel.setLayout(new BorderLayout());
        panel3.setLayout(new GridLayout(2,2));
        questionPanel.add(panel3, BorderLayout.CENTER);
        questionPanel.add(label1, BorderLayout.NORTH);
        panel3.add(svar1);
        panel3.add(svar2);
        panel3.add(svar3);
        panel3.add(svar4);

        svar1.addActionListener(this);
        svar2.addActionListener(this);
        svar3.addActionListener(this);
        svar4.addActionListener(this);

        label1.setText("Fråga");
    }
    public void scoreFrame(){
        scorePanel = new JPanel();
        JPanel panel4 = new JPanel();
        add(scorePanel);
        JLabel name1 = new JLabel("Namn 1: ");
        JLabel name2 = new JLabel("Namn 2: ");
        score1 = new JLabel(0 + " poäng" + "     ");
        score2 = new JLabel(0 + " poäng");
        scorePanel.setLayout(new BorderLayout());
        scorePanel.add(panel4);
        scorePanel.add(label1, BorderLayout.NORTH);
        panel4.add(name1);
        panel4.add(score1);
        panel4.add(name2);
        panel4.add(score2);

        label1.setText("Score"); //går inte att köra metoden utan denna rad, lite skumt
    }

    /*public static void main(String[] args){

        QuizFrames f = new QuizFrames();
        f.startFrame();
    }*/

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == changeName) {
            System.out.println(changeName.getText());
        }
        else if (e.getSource() == category1) {
            remove(categoryPanel);
            questionFrame();
        }
        else if (e.getSource() == svar1) {
            remove(questionPanel);
            scoreFrame();
        }
    }

}
