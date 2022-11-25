package Client;

import javax.swing.*;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client extends JFrame {
    private final InetAddress address = InetAddress.getLocalHost();

    public Client() throws IOException {
        int port = 55553;

        try (
                Socket socket = new Socket(address, port);
                ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {




            String fromserver = "";
            fromserver = input.readObject().toString();
            System.out.println(fromserver);


            //int categoryAmount = (int) input.readObject();
                /*for (int i = 0; i < 2; i++) {
                    String categoryChoice = userInput.readLine();
                    output.writeObject(categoryChoice);
                    //int questionAmount = (int) input.readObject();
                    for (int j = 0; j < 2; j++) {
                        Server.ServerQuestionLogic.QuestionRound round = (Server.ServerQuestionLogic.QuestionRound) input.readObject();
                        System.out.println(round.toString());
                        String answer = userInput.readLine();
                        output.writeObject(answer);
                    }*/

                 /*
            String name = JOptionPane.showInputDialog("Skriv ditt namn: ");
            output.println(name);
            Object object = input.readObject();
            Server.Question question = (Server.Question) object;
            String description = question.getDescription();
            String[] answers = question.getAnswers();
            int correctAnswerIndex = question.getCorrectAnswerindex();
            System.out.println();
            JOptionPane.showMessageDialog(null, "Frågan är: " + description + "\n" + "Svarsalternativ är: " + Arrays.toString(answers));
            String inputString = JOptionPane.showInputDialog("Ange rätt svar: ");
            if(Integer.parseInt(inputString) == correctAnswerIndex){
                JOptionPane.showMessageDialog(null, "Bra, rätt svar.");
            }
            else {
                JOptionPane.showMessageDialog(null, "FEL! Rätt svar är: " + answers[correctAnswerIndex]);
            }
*/

        } catch(
                ClassNotFoundException e)

        {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) throws IOException
    {
        Client c = new Client();
    }
}
