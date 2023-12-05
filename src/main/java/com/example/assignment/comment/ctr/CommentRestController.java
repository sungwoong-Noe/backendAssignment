package com.example.assignment.comment.ctr;

import com.example.assignment.comment.domain.request.CommentRequest;
import com.example.assignment.comment.svc.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/comment")
@RestController
@RequiredArgsConstructor
public class CommentRestController {


    private final CommentService commentService;


    @PostMapping("/regist")
    public void registComment(@RequestBody CommentRequest request) {

        commentService.regist(request);
    }


}
