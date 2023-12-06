package com.example.assignment.comment.domain;

import com.example.assignment.comment.domain.request.CommentRequest;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Comment {

    private Long id;

    private String content;

    private String writer;

    private LocalDateTime registDate;


    @Builder
    public Comment(Long id, String content, String writer, LocalDateTime registDate) {
        this.id = id;
        this.content = content;
        this.writer = writer;
        this.registDate = registDate;
    }


    public static Comment of(CommentRequest request) {
        return Comment.builder().id(request.getId())
                .content(request.getContent())
                .writer(request.getWriter())
                .registDate(LocalDateTime.now())
                .build();
    }
}
