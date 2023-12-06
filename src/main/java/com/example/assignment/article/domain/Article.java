package com.example.assignment.article.domain;


import com.example.assignment.article.domain.request.ArticleRequest;
import com.example.assignment.comment.domain.Comment;
import com.example.assignment.comment.domain.request.CommentRequest;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Article {

    private Long id;

    private String title;

    private String content;

    private String writer;

    private LocalDateTime registDate;

    private List<Comment> commentList;


    @Builder
    public Article(Long id, String title, String content, String writer, LocalDateTime registDate, List<Comment> commentList) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.registDate = registDate;
        this.commentList = commentList;
    }

    public static Article of(Long id, String title, String content, String writer){
        return Article.builder()
                .id(id)
                .title(title)
                .content(content)
                .writer(writer)
                .registDate(LocalDateTime.now())
                .commentList(new ArrayList<>())
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


    public void addComment(CommentRequest request) {
        this.commentList.add(request.toComment());
    }
}
