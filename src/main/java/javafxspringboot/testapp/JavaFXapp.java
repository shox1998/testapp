package javafxspringboot.testapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

public class JavaFXapp extends Application
{
    private ConfigurableApplicationContext applicationContext;
    public Stage stage;
    public FxWeaver fxWeaver;
    @Override
    public void init() throws Exception {
        String [] args = getParameters().getRaw().toArray(new String[0]);
        this.applicationContext = new SpringApplicationBuilder()
                .sources(TestappApplication.class).run(args);
    }

    @Override
    public void stop() throws Exception {
        this.applicationContext.close();
        Platform.exit();
    }  

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        FxWeaver fxWeaver = applicationContext.getBean(FxWeaver.class);
        MainController mainController = (MainController) applicationContext.getBean("mainController");

        stage.setResizable(false);
        stage.setTitle("Quiz Application");
        mainController.setStage(stage);
        //quizController.setStage(stage);
        Parent root = fxWeaver.loadView(MainController.class);

        Scene scene = new Scene(root);

        stage.setScene(scene);

        stage.show();

    }
    @Bean
    public Stage getStage() {
        return stage;
    }

}
