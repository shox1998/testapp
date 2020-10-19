package javafxspringboot.testapp;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafxspringboot.testapp.models.AnswerEntity;
import javafxspringboot.testapp.models.QuestionEntity;
import javafxspringboot.testapp.repositories.AnswerRepository;
import javafxspringboot.testapp.repositories.QuestionRepository;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.applet.Main;

import java.net.URL;
import java.util.*;

@Component
@FxmlView("quiz.fxml")
public class QuizController implements Initializable {

    private static QuizController instance;
    Stage stage;
    @Autowired
    FxWeaver fxWeaver;
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    AnswerRepository answerRepository;
    Map<Integer,String> ansMap;
    List<AnswerEntity> ansList;
    ToggleGroup group;
    Optional<QuestionEntity> question;
    private int count;
    private int id;
    private int countOfCorrects;

    public int getCountOfCorrects() {
        return countOfCorrects;
    }

    private int chk;
    @FXML
    Text qText;
    @FXML
    Button btnFinish;
    @FXML
    JFXButton btnNext;
    @FXML
    JFXRadioButton a1;
    @FXML
    JFXRadioButton a2;
    @FXML
    JFXRadioButton a3;
    @FXML
    JFXRadioButton a4;

    public QuizController() {
        instance = this;
    }

    @FXML
    public void finishQuiz(ActionEvent e)
    {
     setDialogBox();
          //  System.gc();

    }

    private void setDialogBox() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setContentText("Do you want to exit the application");
        Optional<javafx.scene.control.ButtonType> action = alert.showAndWait();
        if ((action.isPresent()) && (action.get() ==javafx.scene.control.ButtonType.OK)){
            System.gc();
            this.finishView();
        }
    }
    public void setInitialValues()
    {
        this.countOfCorrects=0;
        this.count=0;
    }
    private void finishView() {
        Parent root = this.fxWeaver.loadView(FinishController.class);
        Scene scene = new Scene(root);
        this.stage.setScene(scene);
        this.stage.setResizable(false);
        this.stage.show();
    }

    public static QuizController getInstance() {
        return instance;
    }

    @FXML
    public void nextQuiz(ActionEvent e)
    {
        id++;
        countOfCorrects +=checkCorrectAns();
        updateToggle();
        if(count<9)
        {

         redQA(id);
        }
        else {
            System.out.println(countOfCorrects);
            this.finishQuiz(e);
        }
    }

    private void updateToggle() {
        a1.setSelected(false);
        a2.setSelected(false);
        a3.setSelected(false);
        a4.setSelected(false);
    }

    private int checkCorrectAns() {
        return ansList.get(chk-1).getCorrect()== true ? 1:0;
    }

    @FXML
    public void groupAction(ActionEvent actionEvent) {
        if(a1.isSelected()) {
        chk = 1;
        }
        else if(a2.isSelected()){
            chk = 2;
        }else if(a3.isSelected())
        {
            chk = 3;
        }else if(a4.isSelected()){
            chk = 4;
        }

    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.stage = MainController.getInstance().getStage();

        id = 1;
        count = 0;
        group = new ToggleGroup();

        a1.setToggleGroup(group);
        a2.setToggleGroup(group);
        a3.setToggleGroup(group);
        a4.setToggleGroup(group);
        redQA(id);

    }

    public Stage getStage() {

        return stage;
    }

    private void redQA(int i) {
        ansMap = new HashMap<Integer,String>();
        question = questionRepository.findById(i);
        QuestionEntity q=question.get();
        ansList = answerRepository.findAllByQuestionId(i);

        qText.setText("Q|"+i+q.getQuestionContent());

        a1.setText(ansList.get(0).getAnswerContent());
        a2.setText(ansList.get(1).getAnswerContent());
        a3.setText(ansList.get(2).getAnswerContent());
        a4.setText(ansList.get(3).getAnswerContent());
        count++;

       // int j = selectedToggle(a1,a2,a3,a4);
/*        for ( AnswerEntity a:ansList) {
            System.out.println(a.getCorrect());
        }*/

    }

    /*private int selectedToggle(JFXRadioButton a1, JFXRadioButton a2, JFXRadioButton a3, JFXRadioButton a4) {

    }*/
}
