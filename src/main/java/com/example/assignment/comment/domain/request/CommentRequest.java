package com.example.assignment.comment.domain.request;

import com.example.assignment.comment.domain.Comment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequest {

    private Long id;

    private String content;

    private String writer;

    private Long articleId;

    public Comment toComment() {

        return Comment.of(this);
    }
}
