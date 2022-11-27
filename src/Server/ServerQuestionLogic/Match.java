package Server.ServerQuestionLogic;

import Server.Player;
import Server.QuestionDataBase;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Match {
    public Match(Player player1, Player player2) throws IOException, ClassNotFoundException {
        //Logiken för spelet
        //Skickande av data mellan server och clients
        Path p = Paths.get("src/Server/Questions.txt");
        QuestionDataBase d = new QuestionDataBase(p);

        try (
                ObjectOutputStream outputp1 = new ObjectOutputStream(player1.getSocket().getOutputStream());
                ObjectInputStream inputp1 = new ObjectInputStream(player1.getSocket().getInputStream());
                ObjectOutputStream outputp2 = new ObjectOutputStream(player2.getSocket().getOutputStream());
                ObjectInputStream inputp2 = new ObjectInputStream(player2.getSocket().getInputStream())) {

            outputp1.writeObject("WELCOME " + player1.getName());
            outputp2.writeObject("WELCOME " + player2.getName());
            outputp1.writeObject(player1.isCurrentPlayer()); //skriver om client är currentPlayer
            outputp2.writeObject(player2.isCurrentPlayer());
            String category = "";
            if(player1.isCurrentPlayer().equals("yes")){
                category = (String)inputp1.readObject(); //läser in kategorivalet

            }
            else if (player2.isCurrentPlayer().equals("yes")) {
                category = (String) inputp2.readObject();
            }
            CategoryRound categoryRound = createCategoryRound(category);
            ArrayList<QuestionRound> rounds = categoryRound.getRounds();

            for (QuestionRound round : rounds) {
                outputp1.writeObject(round);
            }


            /*while (true) {

                if (checkRemainingCategories()) {
                    outputp1.writeObject(player1.isCurrentPlayer()); //skriver till client om den är första spelaren
                    outputp2.writeObject(player2.isCurrentPlayer());

                    String category = "";

                    if (player1.isCurrentPlayer().equals("yes")){
                        outputp1.writeObject("Choose category");
                        category = (String) inputp1.readObject();
                    }
                    else if (player2.isCurrentPlayer().equals("no")) {
                        outputp2.writeObject("Choose category");
                        category = (String) inputp2.readObject();
                    }

                    System.out.println(category); //skriver ut kategorin

                    CategoryRound categoryRound = createCategoryRound(category);
                    ArrayList<QuestionRound> rounds = categoryRound.getRounds();

                    for (QuestionRound round : rounds) {
                        outputp1.writeObject(round);
                        outputp2.writeObject(round);
                        String answer1 = (String) inputp1.readObject(); //läser in sträng
                        String answer2 = (String) inputp2.readObject(); //läser in sträng
                        boolean p1Right = round.checkResult(answer1); //har person 1 rätt?
                        boolean p2Right = round.checkResult(answer2); //har person 2 rätt?
                        scoreUpdater(p1Right, p2Right);
                    }
                    System.out.println("klar med kategori 1");
                    categoriesLeft--;
                    player1.setCurrentPlayer("no"); //byter currentPlayer, detta måste utvecklas
                    player2.setCurrentPlayer("yes");
                } else {
                    System.out.println("Player 1 Score: " + getPlayer1Score());
                    System.out.println("Player 2 Score: " + getPlayer2Score());
                    break;
                }
            }
            outputp1.writeObject("Your score: " + getPlayer1Score() + "\nPlayer 2 Score: " + getPlayer2Score());
            outputp2.writeObject("Your score: " + getPlayer2Score() + "\nPlayer 1 Score: " + getPlayer1Score());*/
            } catch(IOException e){
                throw new RuntimeException(e);
            }
    }
    private int player1Score = 0;
    private int player2Score = 0;

    int categoriesLeft = 2;

    public boolean checkRemainingCategories(){
        return categoriesLeft > 0;
    }

    public CategoryRound createCategoryRound(String category){
        return new CategoryRound(category);
    }

    public void scoreUpdater(boolean player1scored, boolean player2scored){
        if (player1scored) {
            setPlayer1Score(getPlayer1Score() + 1);
        }
        if (player2scored) {
            setPlayer2Score(getPlayer2Score() + 1);
        }
    }

    public int getPlayer1Score() {
        return player1Score;
    }

    public void setPlayer1Score(int player1Score) {
        this.player1Score = player1Score;
    }

    public int getPlayer2Score() {
        return player2Score;
    }

    public void setPlayer2Score(int player2Score) {
        this.player2Score = player2Score;
    }
}
