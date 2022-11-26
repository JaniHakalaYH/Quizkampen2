package Server.ServerQuestionLogic;

import Server.Question;

import java.io.Serializable;

public class QuestionRound implements Serializable {
    Question question;

    QuestionRound(Question question) {
        this.question = question;
    }

    public Question getQuestion() {
        return question;
    }

    public boolean checkResult(String answer) {
        if (answer.equals(question.getAnswers()[question.getCorrectAnswerindex()])){
            return true;

        } else {
            return false;
        }
    }
}


