package com.job.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.job.Model.Post;

public interface PostRepository extends MongoRepository<Post,String>{

}
