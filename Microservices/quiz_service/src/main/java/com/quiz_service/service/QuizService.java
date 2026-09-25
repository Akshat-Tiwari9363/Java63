package com.quiz_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quiz_service.dao.QuizDao;
import com.quiz_service.feign.QuizInterface;
import com.quiz_service.model.QuestionWapper;
import com.quiz_service.model.Quiz;
import com.quiz_service.model.Response;

@Service 
public class QuizService {

    @Autowired 
    QuizDao quizDao;

    @Autowired 
    QuizInterface quizInterface;

    public ResponseEntity<String> createQuiz(String category,int numQ,String title){
        List<Integer> questions=quizInterface.getQuestionsForQuiz(category,numQ).getBody();
        
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(questions);
        quizDao.save(quiz);
        
        return new ResponseEntity<>("Success",HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWapper>> getQuizQuestions(Integer id){
        Quiz quiz=quizDao.findById(id).orElseThrow(() -> new RuntimeException("Quiz not found with id: " + id));
        List<Integer> questionIds=quiz.getQuestionIds();
        ResponseEntity<List<QuestionWapper>> ques=quizInterface.getQuestionsFromId(questionIds);
        return ques;
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses){
        ResponseEntity<Integer> score=quizInterface.getScore(responses);
        return score;
    }

}
