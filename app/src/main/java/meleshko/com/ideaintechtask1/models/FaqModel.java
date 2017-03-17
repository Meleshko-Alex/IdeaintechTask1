package meleshko.com.ideaintechtask1.models;

public class FaqModel {
    private String quation;
    private String answer;

    public FaqModel(String quation, String answer) {
        this.quation = quation;
        this.answer = answer;
    }

    public String getQuation() {
        return quation;
    }

    public String getAnswer() {
        return answer;
    }
}
