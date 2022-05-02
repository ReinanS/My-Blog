package edu.com.pweb.newsblog.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RestController
@RequestMapping("/posts")
@Api(value = "API REST posts")
@CrossOrigin(origins = "*")
public class PostController {

    final PostService postService;

    @ApiOperation(value = "Retorna os posts por página")
    @GetMapping
    public Page<PostOut> listar(Pageable pageable) throws Exception {
        return postService.list(pageable);
    }
    
    @ApiOperation(value = "Salva um post")
    @PostMapping
    public ResponseEntity<PostOut> cadastrar(@Valid @RequestBody PostIn postIn) {
        PostOut post = postService.cadastrar(postIn);
        return new ResponseEntity<PostOut>(post, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Retorna um post por id")
    @GetMapping("/{id}")
    public ResponseEntity<PostOut> detalhar(@PathVariable Long id) {
        PostOut post = postService.findById(id);
        return new ResponseEntity<PostOut>(post, HttpStatus.OK);
    }   

    @ApiOperation(value = "Atualiza um post")
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> atualizar(@Valid @PathVariable Long id, @RequestBody PostUpdateIn postIn) {
        postService.atualizar(id, postIn);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "Deleta um post por id")
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        postService.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
