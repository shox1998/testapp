package javafxspringboot.testapp.repositories;

import javafxspringboot.testapp.models.AnswerEntity;
import javafxspringboot.testapp.models.QuestionEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public interface AnswerRepository extends CrudRepository<AnswerEntity,Integer> {

    public List<AnswerEntity> findAllByQuestionId(Integer question_id);
}
