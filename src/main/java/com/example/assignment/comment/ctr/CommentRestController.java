package com.example.assignment.comment.ctr;

import com.example.assignment.comment.domain.request.CommentRequest;
import com.example.assignment.comment.svc.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/comment")
@RestController
@RequiredArgsConstructor
public class CommentRestController {


    private final CommentService commentService;


    @PostMapping("/regist")
    public void registComment(@RequestBody CommentRequest request) {

        log.info("==== 댓글 작성 요청 /comment/regist ====", request.getArticleId());

        commentService.regist(request);
    }


}
