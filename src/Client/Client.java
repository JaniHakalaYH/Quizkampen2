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

            boolean isFirstPlayer = input.readBoolean(); //läser in om client är first player

            String fromserver = (String) input.readObject();
            System.out.println(fromserver);


            //int categoryAmount = (int) input.readObject();
            for (int i = 0; i < 2; i++) {
                if(isFirstPlayer){
                    System.out.println(input.readObject()); //frågar om kategori
                    String categoryChoice = userInput.readLine();
                    output.writeObject(categoryChoice);
                }
                //int questionAmount = (int) input.readObject();
                for (int j = 0; j < 2; j++) {
                    QuestionRound round = (QuestionRound) input.readObject();
                    //System.out.println(round.getQuestion().getDescription());
                    System.out.println("frågan");
                    String answer = userInput.readLine();
                    output.writeObject(answer); //en sträng
                }
            }
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
        if (e.getSource() == startbutton) {
            this.dispose();
            QuizFrames q = new QuizFrames(output, input);
            q.categoryFrame();
        } else if (e.getSource() == changeName) {


        }
    }
}
