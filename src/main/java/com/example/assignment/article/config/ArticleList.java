package com.example.assignment.article.config;

import com.example.assignment.article.domain.Article;
import com.example.assignment.comment.domain.request.CommentRequest;
import lombok.Getter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
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

    public List<Article> getDataList() {
        return dataList;
    }


    public Article getDataById(Long id) {

        return this.dataList.stream().filter(article -> Objects.equals(article.getId(), id)).findFirst().orElse(null);
    }


    public void registCommantByArticleId(CommentRequest request) {
        Article article = this.getDataById(request.getArticleId());
        article.addComment(request);
    }

}
