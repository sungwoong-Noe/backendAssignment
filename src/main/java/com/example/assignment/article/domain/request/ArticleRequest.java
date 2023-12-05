package com.example.assignment.article.domain.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleRequest {

    private Long id;

    private String title;

    private String content;

    private String writer;


}
