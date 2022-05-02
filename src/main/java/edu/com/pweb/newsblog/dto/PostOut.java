package edu.com.pweb.newsblog.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import edu.com.pweb.newsblog.model.Categoria;
import edu.com.pweb.newsblog.model.Post;
import lombok.Getter;

@Getter
public class PostOut {
    private Long id;
    private String titulo;
    private String texto;
    private UsuarioOut usuario;
    private Categoria categoria;

    public PostOut(Post post) {
        this.id = post.getId();
        this.titulo = post.getTitulo();
        this.texto = post.getTexto();
        this.usuario = new UsuarioOut(post.getUsuario());
        this.categoria = post.getCategoria();
    }


    public static List<PostOut> converte(List<Post> lista) {
        return lista.stream().map(PostOut::new).collect(Collectors.toList());        
    }

    public static Page<PostOut> convertFromPage(Page<Post> page) {
        return page.map(PostOut::new);
    }
}
