package com.example.assignment.comment.svc;

import com.example.assignment.article.config.ArticleList;
import com.example.assignment.article.domain.Article;
import com.example.assignment.comment.domain.request.CommentRequest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommentServiceTest {

    @Autowired
    ArticleList articleList;

    @Autowired
    CommentService commentService;


    @Test
    public void regist() {
        //given
        Article article_1 = articleList.getDataById(1L);

        //when
        CommentRequest request = new CommentRequest();
        request.setArticleId(article_1.getId());
        request.setContent("comment1");
        request.setWriter("writer1");
        commentService.regist(request);


        //then
        Assertions.assertThat(article_1.getCommentList().get(0).getContent()).isEqualTo("comment1");
        Assertions.assertThat(article_1.getCommentList().get(0).getWriter()).isEqualTo("writer1");


    }

}