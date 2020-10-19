package javafxspringboot.testapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Root;

@Component
@FxmlView("main.fxml")
public class MainController {
    private static MainController instance;
    private Stage stage;
    @Autowired
    FxWeaver fxWeaver;
    @FXML
    private Button startButton;
    @FXML
    public void startQuiz(ActionEvent actionEvent) {

        System.out.println(this.stage.getMaxHeight());
        Parent root = this.fxWeaver.loadView(QuizController.class);
        Scene scene = new Scene(root);
        this.stage.setScene(scene);
        this.stage.setResizable(false);
        this.stage.show();

        }

    public MainController() {
      instance = this;
    }
    public static MainController getInstance(){
        return instance;
    }

    public   Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
