package edu.com.pweb.newsblog.service;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import edu.com.pweb.newsblog.dto.PostIn;
import edu.com.pweb.newsblog.dto.PostOut;
import edu.com.pweb.newsblog.dto.PostUpdateIn;
import edu.com.pweb.newsblog.model.Post;
import edu.com.pweb.newsblog.model.Usuario;
import edu.com.pweb.newsblog.respository.PostRepository;
import edu.com.pweb.newsblog.respository.UsuarioRepository;
import lombok.RequiredArgsConstructor;



// LÓGICA DE NEGÓCIOS



@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;
    private final UsuarioRepository usuarioRepository;

    public List<PostOut> listAll() {
        return PostOut.converte(postRepository.findAll());
    }

    public PostOut findById(Long id) {
        PostOut postOut = null;

        try {
            Post post = postRepository.findById(id).get();
             postOut = new PostOut(post);

        } catch (NoSuchElementException exception) {
            System.out.println("OCORREU UMA EXCESSÃO, POST INEXISTENTE");
            throw new ResponseStatusException(NOT_FOUND);
        }

        return postOut;
    }

    public List<PostOut> findByTitulo(String titulo) {
        return PostOut.converte(postRepository.findByTitulo(titulo));
    }

    public List<PostOut> findByUsuario(String nome) {
        return PostOut.converte(postRepository.findByUsuarioNome(nome));
    }

    // ERROR


    public List<PostOut> findByTituloContaining(String titulo) {
        return PostOut.converte(postRepository.findByTituloContaining(titulo));
    }

    public List<PostOut> findByTituloStartsWith(String titulo) {
        return PostOut.converte(postRepository.findByTituloStartsWith(titulo));
    }

    public PostOut cadastrar(PostIn postIn) {
        PostOut postOut = null;

        try {

            Optional<Usuario> usuario = usuarioRepository.findById(Long.parseLong(postIn.getIdUsuario()));
            Post post = new Post(postIn.getTitulo(), postIn.getTexto(), usuario.get(), postIn.getCategoria());

            postRepository.save(post);
            postOut = new PostOut(post);

        } catch (NoSuchElementException exception) {
            System.out.println("OCORREU UMA EXCESSÃO, USUÁRIO INEXISTENTE");
            throw new ResponseStatusException(NOT_FOUND);
        }

        return postOut;

    }

    public void atualizar(Long id, PostUpdateIn postUpdate) {

        try {
            Post post = postRepository.getById(id);

            post.setTexto(postUpdate.getTexto());
            post.setTitulo(postUpdate.getTitulo());
            post.setCategoria(postUpdate.getCategoria());

        } catch (NoSuchElementException exception) {
            System.out.println("OCORREU UMA EXCESSÃO, POST INEXISTENTE");
            throw new ResponseStatusException(NOT_FOUND);
        }

    }

    public void deletar(Long id) {
        postRepository.deleteById(id);
    }

}
