package com.aaryan.Quizapp.Service;

import com.aaryan.Quizapp.model.Question;
import com.aaryan.Quizapp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questiondao;

    public ResponseEntity<List<Question>> getAllQuestions() {
        // If the request is correct then it will return all questions or else it will return an empty list
        try{
            return new ResponseEntity<>(questiondao.findAll(), HttpStatus.OK); //findall method returns us the list of all questions
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        // If the request is correct then it will return all questions or else it will return an empty list
        try{
            //we dont have any predefined method in jpa, so we create a method in DAO
            return new ResponseEntity<>(questiondao.findByCategory(category), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(@RequestBody Question question) {
        //RequestBody is used to because we are sending the data in the REQUEST in the body
        try{
            questiondao.save(question);
            //we dont have any predefined method in jpa, so we create a method in DAO
            return new ResponseEntity<>("success", HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Fail", HttpStatus.BAD_REQUEST);
    }
}
