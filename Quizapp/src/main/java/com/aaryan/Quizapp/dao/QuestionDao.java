package com.aaryan.Quizapp.dao;

import com.aaryan.Quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {
    //JpaRepository asks for two things only -->   <TableName, TypeOfPrimaryKey>

    List<Question> findByCategory(String category);

    @Query(value = "SELECT * FROM question q WHERE q.category=:category ORDER BY RANDOM() LIMIT :noQues", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category, int noQues);
    //JPA is smart enough to understand that it is asking to find through category but this is over its understanding
    //So we need to write Native Query

}
