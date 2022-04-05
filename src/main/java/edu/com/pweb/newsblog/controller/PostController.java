package edu.com.pweb.newsblog.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.com.pweb.newsblog.model.dto.PostOut;
import edu.com.pweb.newsblog.service.PostService;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RestController
public class PostController {

    final PostService postService;

    @GetMapping("/posts")
    public List<PostOut> listar(String titulo) {
        return postService.findByTituloStartsWith(titulo);
    }


    
}
