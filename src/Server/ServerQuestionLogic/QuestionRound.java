package Server.ServerQuestionLogic;

import java.io.Serializable;

public class QuestionRound implements Serializable {
    Question question;
    int result;

    QuestionRound(Question question){
        this.question = question;
        this.result = 0;
    }

    public void checkResult(){
        if (result == question.getCorrectAnswerindex()){
            setResult(1);
        }
        else {
            setResult(-1);
        }
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getResult() {
        return result;
    }
}
