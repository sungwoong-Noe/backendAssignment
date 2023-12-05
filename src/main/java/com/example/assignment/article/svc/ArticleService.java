package com.example.assignment.article.svc;

import com.example.assignment.article.config.ArticleList;
import com.example.assignment.article.domain.Article;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleList articleList;


    public List<Article> getArticleList() {

        return articleList.getDataList();
    }

}
