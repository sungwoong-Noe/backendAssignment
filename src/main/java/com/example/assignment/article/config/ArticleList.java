package com.example.assignment.article.config;

import com.example.assignment.article.domain.Article;
import lombok.Getter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class ArticleList {

    private List<Article> dataList = new ArrayList<>();
    public ArticleList() {
        for (int i = 0; i <  20; i++) {

            Long id = (long) i + 1;

            String title = "title" + id;
            String content = "content" + id;
            String writer = " writer" + id;

            this.dataList.add(Article.of(id, title, content, writer));
        }
    }


    //    @Bean
//    public List<Article> getArticleList() {
//
//        List<Article> articles = new ArrayList<>();
//
//        for (int i = 0; i <  20; i++) {
//
//            Long id = (long) i + 1;
//
//            String title = "title" + id;
//            String content = "content" + id;
//            String writer = " writer" + id;
//
//            articles.add(Article.of(id, title, content, writer));
//        }
//
//
//        return articles;
//    }
}
