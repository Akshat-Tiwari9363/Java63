package com.job.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import org.bson.Document;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.job.Model.Post;

@Component
public class SearchRepoImpl implements SearchRepository {

    @Autowired
    MongoClient mongoClient;

    @Autowired
    MongoConverter converter;

    @Override
    public List<Post> findByText(String text) {
        final List<Post> posts= new ArrayList<>();
        MongoDatabase database = mongoClient.getDatabase("jobs");
        MongoCollection<Document> collection = database.getCollection("job");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search", 
        new Document("text", 
        new Document("query", text)
                    .append("path", Arrays.asList("profile", "techs", "desc")))), 
        new Document("$sort", 
        new Document("exp", -1L)), 
        new Document("$limit", 3L)));

        result.forEach(doc->posts.add(converter.read(Post.class, doc)));

        return posts;

    }

}
