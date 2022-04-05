package edu.com.pweb.newsblog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.com.pweb.newsblog.model.dto.PostOut;
import edu.com.pweb.newsblog.respository.PostRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository repository;

    public List<PostOut> listar() {
        return PostOut.converte(repository.findAll());
    }

}
