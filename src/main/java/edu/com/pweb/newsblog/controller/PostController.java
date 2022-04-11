package edu.com.pweb.newsblog.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.com.pweb.newsblog.dto.PostOut;
import edu.com.pweb.newsblog.service.PostService;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/posts")
public class PostController {

    final PostService postService;

    @GetMapping
    public List<PostOut> listar() {
        return postService.listar();
    }
    
}
