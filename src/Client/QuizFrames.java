package Client;

import Server.Question;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizFrames extends JFrame implements ActionListener {

    JButton category1 = new JButton("category");
    JButton category2 = new JButton("category");
    JButton category3 = new JButton("category");
    JButton category4 = new JButton("category");
    JButton category5 = new JButton("category");
    JButton category6 = new JButton("category");
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JLabel label1 = new JLabel();
    JLabel label2 = new JLabel();
    JButton startbutton = new JButton("Starta spel");
    JTextField changeName = new JTextField();
    String name = changeName.getText();


    public void startFrame(){
        add(panel1);
        panel1.add(label1, BorderLayout.NORTH);
        panel1.add(label2, BorderLayout.NORTH);

        label1.setText("Välkommen till Quizkampen");
        panel1.add(changeName);

        add(startbutton, BorderLayout.SOUTH);
        changeName.addActionListener(this);
        startbutton.addActionListener(this);

        setSize(200,200);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void categoryFrame(){
        add(panel1);
        panel1.setLayout(new BorderLayout());
        panel2.setLayout(new GridLayout(3,2));
        panel1.add(panel2, BorderLayout.CENTER);
        panel1.add(label1, BorderLayout.NORTH);
        panel2.add(category1);
        panel2.add(category2);
        panel2.add(category3);
        panel2.add(category4);
        panel2.add(category5);
        panel2.add(category6);

        label1.setText("Välj en kategori");

        category1.addActionListener(this);
        category2.addActionListener(this);
        category3.addActionListener(this);
        category4.addActionListener(this);
        category5.addActionListener(this);
        category6.addActionListener(this);

        setSize(300,500);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void scoreFrame(){

    }
    public void questionFrame(Question question){

    }

    public static void main(String[] args){
        new QuizFrames().startFrame();
        new QuizFrames().categoryFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == changeName){
        }else if (e.getSource() == startbutton){

        }
    }

}
