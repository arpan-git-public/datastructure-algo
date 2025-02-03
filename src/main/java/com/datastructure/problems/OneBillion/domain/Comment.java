package com.datastructure.problems.OneBillion.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Comment {

    private long postId;
    private long id;
    private String name;
    private String email;
    private String body;
}
