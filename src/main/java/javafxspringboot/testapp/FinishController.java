package javafxspringboot.testapp;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
@FxmlView("finish.fxml")

public class FinishController implements Initializable {
    @Autowired
    FxWeaver fxWeaver;
    Stage stage;
    @FXML
    Button restartBtn;
    @FXML
    Button exitBtn;
    @FXML
    Label score;

    private static QuizController quizController;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.printf("Hello Guy");
        this.quizController = QuizController.getInstance();
        this.stage = quizController.getStage();
        score.setText(Integer.toString(quizController.getCountOfCorrects()));
        this.quizController.setInitialValues();
    }

    public void restart(ActionEvent actionEvent) {
        Parent root = this.fxWeaver.loadView(MainController.class);
        Scene scene = new Scene(root);
        this.stage.setScene(scene);
        this.stage.setResizable(false);
        this.stage.show();
    }

    public void exit(ActionEvent actionEvent) {
        Platform.exit();
    }
}
