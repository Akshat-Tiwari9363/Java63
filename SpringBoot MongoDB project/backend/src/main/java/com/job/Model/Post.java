package com.job.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Document(collection = "job")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Post {

    @Id
    private String id;

    private String profile;
    private String desc;
    private Integer exp;
    private String techs[];

}
