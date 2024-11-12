package com.aaryan.Quizapp.Controller;

import com.aaryan.Quizapp.Service.QuizService;
import com.aaryan.Quizapp.model.QuestionWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    //Method to create a quiz from the questions in our question table
    @PostMapping("create")
    public ResponseEntity<String> creatQuiz(@RequestParam String category, @RequestParam int noQues, @RequestParam String title){
        return quizService.creatQuiz(category, noQues, title);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestions(@PathVariable Integer id){
        return quizService.getQuizQuestions(id);
    }
}
