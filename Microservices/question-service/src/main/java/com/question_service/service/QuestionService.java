package com.question_service.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.question_service.dao.QuestionDao;
import com.question_service.model.Question;
import com.question_service.model.QuestionWapper;
import com.question_service.model.Response;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List<Question>> getAllQuestions(){
        try{
            return new ResponseEntity<>(questionDao.findAll(),HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category){
        try{
            return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(Question question){
        questionDao.save(question);
        return  new ResponseEntity<>("success",HttpStatus.CREATED);
    }

    public ResponseEntity<List<Integer>> getQuestionsForQuiz(String category,Integer numQ){
        List<Integer> questions=questionDao.findRandomQuestionsByCategory(category,numQ);
        return new ResponseEntity<>(questions,HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWapper>> getQuestionsFromId(List<Integer> quesIds){
        List<QuestionWapper> wappers=new ArrayList<>();
        List<Question> questions=new ArrayList<>();
        for(Integer id : quesIds){
            questions.add(questionDao.findById(id).get());
        }
        for(Question question : questions){
            QuestionWapper wapper=new QuestionWapper();
            wapper.setId(question.getId());
            wapper.setQuestionTitle(question.getQuestionTitle());
            wapper.setOption1(question.getOption1());
            wapper.setOption2(question.getOption2());
            wapper.setOption3(question.getOption3());
            wapper.setOption4(question.getOption4());
            wappers.add(wapper);
        }
        return new ResponseEntity<>(wappers,HttpStatus.OK);
    }

    public ResponseEntity<Integer> getScore(List<Response> responses){
        int right=0;
        for(Response response : responses){
            Question question = questionDao.findById(response.getId()).get();
            if(response.getResponse().equals(question.getRightAnswer())){
                right++;
            }
        }
        return new ResponseEntity<>(right,HttpStatus.OK);
    }

}
