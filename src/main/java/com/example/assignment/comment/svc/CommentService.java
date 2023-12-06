package com.example.assignment.comment.svc;

import com.example.assignment.article.config.ArticleList;
import com.example.assignment.comment.domain.request.CommentRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CommentService {

    private final ArticleList articleList;

    public void regist(CommentRequest request) {

        articleList.registCommantByArticleId(request);
        log.info("==== 댓글 작성 articleId: {}, 작성자: {}  ====", request.getArticleId(), request.getWriter());
    }
}

