package com.example.assignment.article.svc;

import com.example.assignment.article.domain.Article;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ArticleServiceTest {

    @Autowired
    ArticleService articleService;


    @Test
    @DisplayName(value = "초기값 테스트 게시글 데이터는 20개로 초기화 한다.")
    public void test1() {

        //given - 초기
        List<Article> articleList = articleService.getArticleList();


        //expected
        Assertions.assertThat(articleList.size()).isEqualTo(20);
    }
}