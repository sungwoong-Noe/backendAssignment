package com.example.assignment.article.domain.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequest {

    private Long id;

    private String content;

    private String writer;
}
