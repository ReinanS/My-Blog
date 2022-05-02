package edu.com.pweb.newsblog.service;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import edu.com.pweb.newsblog.dto.PostIn;
import edu.com.pweb.newsblog.dto.PostOut;
import edu.com.pweb.newsblog.dto.PostUpdateIn;
import edu.com.pweb.newsblog.model.Post;
import edu.com.pweb.newsblog.model.Usuario;
import edu.com.pweb.newsblog.respository.PostRepository;
import lombok.RequiredArgsConstructor;



// LÓGICA DE NEGÓCIOS

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;
    private final UsuarioService usuarioService;

    public List<PostOut> listAll() {
        return PostOut.converte(postRepository.findAll());
    }

    public Page<PostOut> list(Pageable pageable) {
        return PostOut.convertFromPage(postRepository.findAll(pageable));
    }


    private Post findByIdOrThrowNotFoundRequestException(Long id) {
        return postRepository.findById(id).orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Post not Found"));
    }

    public PostOut findById(Long id) {
        return new PostOut(findByIdOrThrowNotFoundRequestException(id));
    }

    public List<PostOut> findByTitulo(String titulo) {
        return PostOut.converte(postRepository.findByTitulo(titulo));
    }

    public List<PostOut> findByUsuario(String nome) {
        return PostOut.converte(postRepository.findByUsuarioNome(nome));
    }

    // ERROR
    // ------------------------------------------------------------------------------------------

    public List<PostOut> findByTituloContaining(String titulo) {
        return PostOut.converte(postRepository.findByTituloContaining(titulo));
    }

    public List<PostOut> findByTituloStartsWith(String titulo) {
        return PostOut.converte(postRepository.findByTituloStartsWith(titulo));
    }

    // ------------------------------------------------------------------------------------------


    public PostOut cadastrar(PostIn postIn) {
        Usuario usuario = usuarioService.findByIdOrThrowNotFoundRequestException(Long.parseLong(postIn.getIdUsuario()));
        Post post = new Post(postIn.getTitulo(), postIn.getTexto(), usuario, postIn.getCategoria());

        postRepository.save(post);
        return new PostOut(post);

    }

    public void atualizar(Long id, PostUpdateIn postUpdate) {

        Post savedPost = findByIdOrThrowNotFoundRequestException(id);
        Post post = new Post(savedPost.getId(), postUpdate.getTitulo(), postUpdate.getTexto(), savedPost.getUsuario(), postUpdate.getCategoria());
        
        postRepository.save(post);
      
    }

    public void deletar(Long id) {
        postRepository.delete(findByIdOrThrowNotFoundRequestException(id));
    }

}
