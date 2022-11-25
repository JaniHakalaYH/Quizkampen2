package Server.ServerQuestionLogic;

import Server.Player;
import Server.Question;
import Server.QuestionDataBase;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Match {
    public Match(Player player1, Player player2) throws IOException, ClassNotFoundException {
        //Logiken för spelet
        //Skickande av data mellan server och clients
        Path p = Paths.get("src/main/java/Server/questions.txt");
        QuestionDataBase d = new QuestionDataBase();
        Question q = d.getRandomQuestionFromCategory("Sport");

        try (
                ObjectOutputStream outputp1 = new ObjectOutputStream(player1.getSocket().getOutputStream());
                ObjectInputStream inputp1 = new ObjectInputStream(player1.getSocket().getInputStream());
                ObjectOutputStream outputp2 = new ObjectOutputStream(player2.getSocket().getOutputStream());
                ObjectInputStream inputp2 = new ObjectInputStream(player2.getSocket().getInputStream())) {

            outputp1.writeObject("WELCOME " + player1.getName());
            outputp2.writeObject("WELCOME " + player2.getName());

            outputp1.writeObject(q);
            outputp1.flush();
            outputp2.writeObject(q);
            outputp2.flush();
           /* while (true) {
                if (checkRemainingCategories()) {
                    //output.writeObject(match.getCategoryAmount());
                    outputp1.writeObject("Choose category");
                    String category = String.valueOf(inputp1);
                    System.out.println(category);

                    Server.ServerQuestionLogic.CategoryRound categoryRound = createCategoryRound(category);
                    //output.writeObject(categoryRound.getQuestionsPerCategory());
                    ArrayList<Server.ServerQuestionLogic.QuestionRound> rounds = categoryRound.getRounds();

                    for (Server.ServerQuestionLogic.QuestionRound round : rounds) {
                        outputp1.writeObject(round);
                        outputp2.writeObject(round);
                        Server.ServerQuestionLogic.QuestionRound returnRoundp1 = (Server.ServerQuestionLogic.QuestionRound) inputp1.readObject();
                        Server.ServerQuestionLogic.QuestionRound returnRoundp2 = (Server.ServerQuestionLogic.QuestionRound) inputp2.readObject();
                        returnRoundp1.checkResult();
                        returnRoundp2.checkResult();

                        int successResultp1 = returnRoundp1.getResult();
                        int successResultp2 = returnRoundp2.getResult();
                        boolean success;
                        boolean success2;
                        if (successResultp1 > 0) {
                            success = true;
                        } else if (successResultp1 < 0) {
                            success = false;
                        } else {
                            System.out.println("BIG ERROR");
                            break;
                        }
                        if (successResultp2 > 0) {
                            success2 = true;
                        } else if (successResultp2 < 0) {
                            success2 = false;
                        } else {
                            System.out.println("BIG ERROR");
                            break;
                        }
                        scoreUpdater(success, success2);
                    }
                } else {
                    System.out.println("Server.Player 1 Score: " + getPlayer1Score());
                    System.out.println("Server.Player 2 Score: " + getPlayer2Score());
                    break;
                }
            }
            } catch(IOException e){
                throw new RuntimeException(e);
            }*/
        }
    }
    private int player1Score = 0;
    private int player2Score = 0;

    public int getCategoryAmount() {
        return categoryAmount;
    }

    int categoryAmount = 2;

    public boolean checkRemainingCategories(){
        return categoryAmount < 0;
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
