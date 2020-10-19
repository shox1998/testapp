package javafxspringboot.testapp.models;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "question_table")
public class QuestionEntity  {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "question_text")
    private String questionContent;
    @OneToMany(mappedBy = "question",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<AnswerEntity> answers;

    public QuestionEntity() {
    }// getter setter кани куйинг кейин текширинг

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public List<AnswerEntity> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerEntity> answers) {
        this.answers = answers;
    }

    public QuestionEntity(String qcontent) {
        this.questionContent = qcontent;
    }

    public Integer getId() {
        return id;
    }


}
