package com.studentdata;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
public class StudentController {

    @Autowired
    StudentRepo repo;
    
    @Hidden
    @RequestMapping("/")
    public void requestMethodName(HttpServletResponse response) throws Exception {
        response.sendRedirect("/swagger-ui/index.html");
    }
    

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return repo.findAll();
    }
    
    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student) {
        return repo.save(student);
    }

    @DeleteMapping("/delete")
    public void delete(int id){
        repo.deleteById(id);
    }

}
