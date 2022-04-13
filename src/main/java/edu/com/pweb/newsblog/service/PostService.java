package edu.com.pweb.newsblog.service;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import edu.com.pweb.newsblog.dto.PostOut;
import edu.com.pweb.newsblog.model.Post;
import edu.com.pweb.newsblog.respository.PostRepository;
import lombok.RequiredArgsConstructor;



// LÓGICA DE NEGÓCIOS



@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository repository;

    public List<PostOut> listAll() {
        return PostOut.converte(repository.findAll());
    }

    public PostOut findById(Long id) {
        PostOut postOut = null;

        try {
            Post post = repository.findById(id).get();
             postOut = new PostOut(post);

        } catch (NoSuchElementException exception) {
            System.out.println("OCORREU UMA EXCESSÃO, POST INEXISTENTE");
            throw new ResponseStatusException(NOT_FOUND);
        }

        return postOut;
    }

    public List<PostOut> findByTitulo(String titulo) {
        return PostOut.converte(repository.findByTitulo(titulo));
    }

    public List<PostOut> findByUsuario(String nome) {
        return PostOut.converte(repository.findByUsuarioNome(nome));
    }

    // ERROR


    public List<PostOut> findByTituloContaining(String titulo) {
        return PostOut.converte(repository.findByTituloContaining(titulo));
    }

    public List<PostOut> findByTituloStartsWith(String titulo) {
        return PostOut.converte(repository.findByTituloStartsWith(titulo));
    }

}
