package edu.com.pweb.newsblog.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.com.pweb.newsblog.dto.PostIn;
import edu.com.pweb.newsblog.dto.PostOut;
import edu.com.pweb.newsblog.dto.PostUpdateIn;
import edu.com.pweb.newsblog.service.PostService;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RestController
@RequestMapping("/posts")
public class PostController {

    final PostService postService;

    @GetMapping
    public ResponseEntity<List<PostOut>> listar() {
        List<PostOut> posts = postService.listAll();
        return new ResponseEntity<List<PostOut>>(posts, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<PostOut> cadastrar(@Valid @RequestBody PostIn postIn) {
        PostOut post = postService.cadastrar(postIn);
        return new ResponseEntity<PostOut>(post, HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<PostOut> detalhar(@PathVariable Long id) {
        PostOut post = postService.findById(id);
        return new ResponseEntity<PostOut>(post, HttpStatus.OK);
    }   

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> atualizar(@Valid @PathVariable Long id, @RequestBody PostUpdateIn postIn) {
        postService.atualizar(id, postIn);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        postService.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
