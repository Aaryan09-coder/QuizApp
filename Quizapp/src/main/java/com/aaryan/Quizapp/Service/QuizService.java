package com.aaryan.Quizapp.Service;

import com.aaryan.Quizapp.dao.QuestionDao;
import com.aaryan.Quizapp.dao.QuizDao;
import com.aaryan.Quizapp.model.Question;
import com.aaryan.Quizapp.model.QuestionWrapper;
import com.aaryan.Quizapp.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    //Questions are coming from questionDao so the responsibility of question is with questionDao
    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> creatQuiz(String category, int noQues, String title) {

        List<Question> questions = questionDao.findRandomQuestionsByCategory(category, noQues);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);

        quizDao.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Question> questionsFromDB = quiz.get().getQuestions();
        List<QuestionWrapper> questionForUser = new ArrayList<>();

        for(Question q : questionsFromDB){
            QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
            questionForUser.add(qw);
        }
        return new ResponseEntity<>(questionForUser, HttpStatus.OK);
    }
}
