package com.example.assignment.article.ctr;

import com.example.assignment.article.config.ArticleList;
import com.example.assignment.article.svc.ArticleService;
import com.example.assignment.comment.domain.request.CommentRequest;
import com.example.assignment.comment.svc.CommentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class ArticleRestControllerTest {


    @Autowired
    MockMvc mvc;

    @Autowired
    CommentService commentService;


    @Test
    @DisplayName("게시글 목록 조회")
    public void getList() throws Exception{

        //expected
        mvc.perform(get("/article/list").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;"))
                .andExpect(jsonPath("$", hasSize(20)))
                .andDo(print());
    }

    @Test
    @DisplayName("게시글 상세 조회")
    public void getArticle() throws Exception{

        //given
        Long id = 1L;


        //expected
        mvc.perform(get("/article/{id}", id).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.title").value("title" + id))
                .andExpect(jsonPath("$.content").value("content" + id))
                .andDo(print());
    }


    @Test
    @DisplayName("게시글 상세 조회 - 댓글 추가")
    public void getArticleAndCommentList() throws Exception {
        //given
        Long id = 1L;
        CommentRequest request = new CommentRequest();
        request.setId(1L);
        request.setArticleId(id);
        request.setWriter("writer1");
        request.setContent("content1");

        commentService.regist(request);

        //expected
        mvc.perform(get("/article/{id}", id).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.title").value("title" + id))
                .andExpect(jsonPath("$.content").value("content" + id))
                .andExpect(jsonPath("$.commentList[0].content").value("content1"))
                .andDo(print());
    }

}