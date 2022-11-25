package Server.ServerQuestionLogic;

import Server.Categories;

import java.io.Serializable;
import java.util.ArrayList;

public class CategoryRound implements Serializable {
    public int getQuestionsPerCategory() {
        return questionsPerCategory;
    }

    int questionsPerCategory = 2;
    Categories categories = new Categories();
    ArrayList<QuestionRound> rounds = new ArrayList<>();

    public ArrayList<QuestionRound> getRounds() {
        return rounds;
    }

    CategoryRound(String category){
        for (int i = 0; i < questionsPerCategory; i++) {
            QuestionRound round = new QuestionRound(categories.getCategoriesMap().get(category).get(i));
            rounds.add(round);
        }
    }
}
