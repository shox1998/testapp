package javafxspringboot.testapp.models;

import javax.persistence.*;

@Entity
@Table(name = "answer_table")
public class AnswerEntity  {
    @Id
    @GeneratedValue
    private Integer aid;
    @Column(name = "answer_text")
    private String answerContent;
    private Boolean isCorrect;
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "question_id",nullable = false)
    private QuestionEntity question; //бир хил булиши керак

    public AnswerEntity() {// getter setter кани
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    public Boolean getCorrect() {
        return isCorrect;
    }

    public void setCorrect(Boolean correct) {
        isCorrect = correct;
    }

    public QuestionEntity getQuestion() {
        return question;
    }

    public void setQuestion(QuestionEntity question) {
        this.question = question;
    }

    public AnswerEntity(String answerContent, Boolean isCorrect, QuestionEntity question) {
        this.answerContent = answerContent;
        this.isCorrect = isCorrect;
        this.question = question;
    }

}
