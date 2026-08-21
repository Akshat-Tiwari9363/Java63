package com.job.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.job.Model.Post;
import com.job.Repository.PostRepository;
import com.job.Repository.SearchRepository;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;





@RestController
@CrossOrigin
public class PostController {

    @Autowired
    PostRepository repo;

    @Autowired
    SearchRepository srepo;

    @Hidden
    @RequestMapping("/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }
    
    @CrossOrigin
    @GetMapping("/allPosts")
    public List<Post> getAllPost() {
        return repo.findAll();
    }

    @CrossOrigin
    @GetMapping("/posts/{text}")
    public List<Post> search(@PathVariable String text) {
        return srepo.findByText(text);
    }
    
    @CrossOrigin
    @PostMapping("/post")
    public Post addPost(@RequestBody Post post) {
        return repo.save(post);
    }    
    
}
