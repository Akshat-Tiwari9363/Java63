package com.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentResource {
    @Autowired
    StudentRepo repo;
    
    @GetMapping("student")
    public List<Student> getStudents(){
        List<Student> s=(List<Student>) repo.findAll();
        return s;
    }

    @GetMapping("/get/{id}")
    public Student getStudent(@PathVariable int id){
        Student s= repo.findById(id).orElse(new Student());
        if(s.getId()==0){
            s.setName("Not Found");
        }
        return s;
    }

    @PostMapping("post")
    public Student create(@RequestBody Student s){
        repo.save(s);
        return s;        
    }

    @PutMapping("put")
    public Student update(@RequestBody Student s){
        repo.save(s);
        return s;        
    }

    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable int id){
        Student s= repo.findById(id).orElse(new Student());
        if(s.getId()!=0){
            repo.deleteById(id);
            return "Deleted";
        }
        else{
            return "Not Found";
        }
    }

}