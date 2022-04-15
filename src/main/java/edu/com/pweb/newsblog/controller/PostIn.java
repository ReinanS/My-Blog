package edu.com.pweb.newsblog.controller;

import java.util.List;
import java.util.stream.Collectors;

import edu.com.pweb.newsblog.model.Categoria;
import edu.com.pweb.newsblog.model.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PostIn {
    private String titulo;
    private String texto;
    private Long idUsuario;
    private Categoria categoria;

    public PostIn(Post post) {
        this.titulo = post.getTitulo();
        this.texto = post.getTexto();
        this.idUsuario = post.getUsuario().getId();
        this.categoria = post.getCategoria();
    }

    public static List<PostIn> converte(List<Post> lista) {
        return lista.stream().map(PostIn::new).collect(Collectors.toList());
    }
}
