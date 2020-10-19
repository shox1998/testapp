package javafxspringboot.testapp;

import javafx.application.Application;
import javafxspringboot.testapp.models.AnswerEntity;
import javafxspringboot.testapp.models.QuestionEntity;
import javafxspringboot.testapp.repositories.AnswerRepository;
import javafxspringboot.testapp.repositories.QuestionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class TestappApplication {

    public static void main(String[] args) {

        //SpringApplication.run(TestappApplication.class, args);
        Application.launch(JavaFXapp.class,args);


    }
  /*  @Bean
    public CommandLineRunner mappingDemo(QuestionRepository qRepository,
                                         AnswerRepository aRepository) {
        return args -> {

            // create a new book
            QuestionEntity q = new QuestionEntity("Hello World!");

            // save the book
            qRepository.save(q);

            // create and save new pages
            aRepository.save(new AnswerEntity( "One", false,q));
            aRepository.save(new AnswerEntity( "Two", false,q));
            aRepository.save(new AnswerEntity( "Three", true,q));
            aRepository.save(new AnswerEntity( "Four", false,q));

        };
    }
*/
}