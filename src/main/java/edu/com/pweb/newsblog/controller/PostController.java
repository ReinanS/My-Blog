package edu.com.pweb.newsblog.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.com.pweb.newsblog.dto.PostOut;
import edu.com.pweb.newsblog.service.PostService;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RestController
@RequestMapping("/posts")
public class PostController {

    final PostService postService;

    @GetMapping
    public ResponseEntity<List<PostOut>> list() {
        List<PostOut> posts = postService.listAll();
        return new ResponseEntity<List<PostOut>>(posts, HttpStatus.OK);
    }    

    @GetMapping(path = "/{id}")
    public ResponseEntity<PostOut> findById(@PathVariable Long id) {
        PostOut post = postService.findById(id);
        return new ResponseEntity<PostOut>(post, HttpStatus.OK);




    }   
}
