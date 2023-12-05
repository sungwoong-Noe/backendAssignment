package com.example.assignment.article.domain;


import com.example.assignment.article.domain.request.ArticleRequest;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Article {

    private Long id;

    private String title;

    private String content;

    private String writer;

    private LocalDateTime registDate;


    @Builder
    public Article(Long id, String title, String content, String writer, LocalDateTime registDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.registDate = registDate;
    }

    public static Article of(Long id, String title, String content, String writer){
        return Article.builder()
                .id(id)
                .title(title)
                .content(content)
                .registDate(LocalDateTime.now())
                .build();
    }

    public static Article of(ArticleRequest request) {

        return Article.builder()
                .id(request.getId())
                .title(request.getTitle())
                .content(request.getContent())
                .writer(request.getWriter())
                .registDate(LocalDateTime.now())
                .build();



    }
}
