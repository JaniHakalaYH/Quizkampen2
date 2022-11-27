package Client;

import Server.Question;
import Server.ServerQuestionLogic.QuestionRound;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class QuizFrames extends JFrame implements ActionListener {
    JPanel categoryPanel;
    JPanel questionPanel;
    JPanel scorePanel;
    JLabel label1 = new JLabel();
    JButton category1 = new JButton("Food");
    JButton category2 = new JButton("Sport");
    JButton category3 = new JButton("Geography");
    JButton category4 = new JButton("Animals");
    JButton category5 = new JButton("Swedish History");
    JButton category6 = new JButton("Music");
    JButton svar1 = new JButton("Svar");
    JButton svar2 = new JButton("Svar");
    JButton svar3 = new JButton("Svar");
    JButton svar4 = new JButton("Svar");
    JLabel score1;
    JLabel score2;
    ObjectOutputStream output;
    ObjectInputStream input;
    String categoryChoice;

    public QuizFrames(ObjectOutputStream output, ObjectInputStream input){
        this.output = output;
        this.input = input;
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
    public void questionFrame(QuestionRound questionRound){
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

        svar1.setText(questionRound.getQuestion().getAnswers()[0]);
        svar2.setText(questionRound.getQuestion().getAnswers()[1]);
        svar3.setText(questionRound.getQuestion().getAnswers()[2]);
        svar4.setText(questionRound.getQuestion().getAnswers()[3]);
        svar1.addActionListener(this);
        svar2.addActionListener(this);
        svar3.addActionListener(this);
        svar4.addActionListener(this);

        label1.setText(questionRound.getQuestion().getDescription());


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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == category1) {
            categoryChoice = category1.getText();
            writeToServer(categoryChoice);
            QuestionRound q = (QuestionRound) readFromServer();
            remove(categoryPanel);
            questionFrame(q);
        }
        else if (e.getSource() == category2) {
            categoryChoice = category2.getText();
            writeToServer(categoryChoice);
            QuestionRound q = (QuestionRound) readFromServer();
            remove(categoryPanel);
            questionFrame(q);
        }
        else if (e.getSource() == category3) {
            categoryChoice = category3.getText();
            writeToServer(categoryChoice);
            QuestionRound q = (QuestionRound) readFromServer();
            remove(categoryPanel);
            questionFrame(q);
        }
        else if (e.getSource() == category4) {
            categoryChoice = category4.getText();
            writeToServer(categoryChoice);
            QuestionRound q = (QuestionRound) readFromServer();
            remove(categoryPanel);
            questionFrame(q);
        }
        else if (e.getSource() == category5) {
            categoryChoice = category1.getText();
            writeToServer(categoryChoice);
            QuestionRound q = (QuestionRound) readFromServer();
            remove(categoryPanel);
            questionFrame(q);
        }
        else if (e.getSource() == category6) {
            categoryChoice = category6.getText();
            writeToServer(categoryChoice);
            QuestionRound q = (QuestionRound) readFromServer();
            remove(categoryPanel);
            questionFrame(q);
        }
        else if (e.getSource() == svar1) {
            remove(questionPanel);
            scoreFrame();
        }
    }
    public void writeToServer(Object o){
        try {
            output.writeObject(o);
        } catch (Exception e){
            System.out.println("Error");
            e.printStackTrace();
        }
    }
    public Object readFromServer() {
        try {
            Object o = input.readObject();
            return o;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
