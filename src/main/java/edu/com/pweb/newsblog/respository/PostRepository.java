package edu.com.pweb.newsblog.respository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.com.pweb.newsblog.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post,Long>{

    public Page<Post> findByTitulo(String titulo, Pageable pageable);
    public Optional<Post> findById(Long id);
    public List<Post> findByTitulo(String titulo);
    public List<Post> findByUsuarioNome(String nome);
    public List<Post> findByTituloContaining(String titulo);
    public List<Post> findByTituloStartsWith(String titulo);
}
