package edu.com.pweb.newsblog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.com.pweb.newsblog.dto.PostOut;
import edu.com.pweb.newsblog.respository.PostRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository repository;

    public List<PostOut> listar() {
        return PostOut.converte(repository.findAll());
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
