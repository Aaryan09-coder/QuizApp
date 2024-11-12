package com.aaryan.Quizapp.Controller;

import com.aaryan.Quizapp.model.Question;
import com.aaryan.Quizapp.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// This controller is for questions only

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/allquestion")
    public ResponseEntity<List<Question>> getAllQuestions(){
            return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
        //whenever we are passing a value in path we need to mention path variable annotation
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("addQuestion")
    public ResponseEntity<String> addQuestion(Question question){
        return questionService.addQuestion(question);
    }
}
