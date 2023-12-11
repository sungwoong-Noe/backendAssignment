package com.example.assignment.common;

import com.example.assignment.article.domain.Article;
import lombok.*;

import java.util.List;

@Getter
public class ResponseDto<T> {
    private boolean result;
    private ResponseData<T> data;

    public ResponseDto(boolean result, List<T> contents, int page, int size) {
        this.result = result;
        this.data = new ResponseData<T>(page, size, contents);

    }

    @Getter
    private static class ResponseData<T>{
        private int page;
        private int size;
        private int totalCount;
        private List<T> contents;

        public ResponseData(int page, int size, List<T> contents) {
            this.page = page;
            this.size = size;
            this.totalCount = contents.size();
            this.contents = contents;
        }
    }
}

