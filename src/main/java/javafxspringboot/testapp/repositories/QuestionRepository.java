package javafxspringboot.testapp.repositories;

import javafxspringboot.testapp.models.AnswerEntity;
import javafxspringboot.testapp.models.QuestionEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface QuestionRepository extends CrudRepository<QuestionEntity,Integer> {


}
