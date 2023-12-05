package com.example.assignment.article.svc;

import com.example.assignment.article.config.ArticleList;
import com.example.assignment.article.domain.Article;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ArticleService {

    private final ArticleList articleList;


    public List<Article> getArticleList() {

        log.info("==== 게시글 조회 ====");

        return articleList.getDataList();
    }

}
