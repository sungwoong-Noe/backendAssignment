package com.example.assignment.article.svc;

import com.example.assignment.article.config.ArticleList;
import com.example.assignment.article.domain.Article;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleList articleList;


    public List<Article> getArticleList() {

        log.info("==== 게시글 목록 조회 ====");

        return articleList.getDataList();
    }


    public Article getArticle(Long articleId) {

        log.info("==== 게시글 상세 조회 ID: {} ====", articleId);

        return articleList.getDataById(articleId);
    }
}
