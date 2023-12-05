package com.example.assignment.comment.svc;

import com.example.assignment.article.config.ArticleList;
import com.example.assignment.comment.domain.request.CommentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final ArticleList articleList;

    public void regist(CommentRequest request) {
        articleList.registCommantByArticleId(request);
    }
}

