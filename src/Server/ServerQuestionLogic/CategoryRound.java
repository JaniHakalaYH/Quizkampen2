package Server.ServerQuestionLogic;

import Server.Categories;
import Server.QuestionDataBase;

import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CategoryRound implements Serializable {


    Path p = Paths.get("src/Server/Questions.txt");
    public int getQuestionsPerCategory() {
        return questionsPerCategory;
    }

    int questionsPerCategory = 2;
    QuestionDataBase qdb = new QuestionDataBase(p);
    ArrayList<QuestionRound> rounds = new ArrayList<>();

    public ArrayList<QuestionRound> getRounds() {
        return rounds;
    }

    CategoryRound(String category){
        for (int i = 0; i < questionsPerCategory; i++) {
            QuestionRound round = new QuestionRound(qdb.getRandomQuestionFromCategory(category));
            rounds.add(round);
        }
    }
}
