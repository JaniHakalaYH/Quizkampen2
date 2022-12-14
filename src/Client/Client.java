package Client;

import Server.Player;
import Server.ServerQuestionLogic.QuestionRound;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.sql.SQLOutput;
import java.util.Arrays;

public class Client extends JFrame implements ActionListener {
    private final InetAddress address = InetAddress.getLocalHost();
    JTextField changeName = new JTextField("");
    JPanel startPanel;
    JButton startbutton = new JButton("Starta spel");
    JLabel label1 = new JLabel();
    JLabel label2 = new JLabel();
    Socket socket;
    ObjectOutputStream output;
    ObjectInputStream input;
    BufferedReader userInput;
    String isCurrentPlayer;


    public Client() throws IOException {

        startPanel = new JPanel();
        JPanel namnPanel = new JPanel();
        namnPanel.setLayout(new GridLayout(1, 3));
        changeName.addActionListener(this);
        add(startPanel);
        startPanel.setLayout(new BorderLayout());
        startPanel.add(namnPanel, BorderLayout.NORTH);
        namnPanel.add(label1);
        namnPanel.add(label2);
        namnPanel.add(changeName);
        startPanel.add(startbutton, BorderLayout.SOUTH);

        label1.setText("    Välkommen!");
        label2.setText("Skriv ditt namn:");

        changeName.addActionListener(this);
        startbutton.addActionListener(this);

        setSize(300, 300);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        int port = 55553;

        try {
            socket = new Socket(address, port);
            output = new ObjectOutputStream(socket.getOutputStream());
            input = new ObjectInputStream(socket.getInputStream());
            userInput = new BufferedReader(new InputStreamReader(System.in));

            String fromserver = (String) input.readObject();
            System.out.println(fromserver);
            isCurrentPlayer = (String) input.readObject();

            /*for (int i = 0; i < 2; i++) {
                System.out.println("boolean: ");
                isCurrentPlayer = (String) input.readObject();
                System.out.println(isCurrentPlayer);

                if(isCurrentPlayer.equals("yes")){
                    System.out.println(input.readObject()); //frågar om kategori
                    String categoryChoice = userInput.readLine();
                    output.writeObject(categoryChoice);
                }
                for (int j = 0; j < 2; j++) {
                    QuestionRound round = (QuestionRound) input.readObject();
                    System.out.println(round.getQuestion().getDescription());
                    String answer = userInput.readLine();
                    output.writeObject(answer); //en sträng
                }
            }
            System.out.println(input.readObject());*/
        } catch (
                ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        Client c = new Client();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        QuizFrames q = new QuizFrames(output, input);
        if (e.getSource() == startbutton) {
            if(isCurrentPlayer.equals("yes")){
                this.dispose();
                q.categoryFrame();
            }
            else if (isCurrentPlayer.equals("no")){
                this.dispose();
                q.scoreFrame();
            }
            else {
                System.out.println("FEL");
                System.exit(1);
            }
        } else if (e.getSource() == changeName) {


        }
    }
}
