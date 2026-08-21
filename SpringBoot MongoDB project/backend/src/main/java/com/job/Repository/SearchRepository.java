package com.job.Repository;

import java.util.List;

import com.job.Model.Post;

public interface SearchRepository {

    List<Post> findByText(String text);

}
