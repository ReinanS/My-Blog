package edu.com.pweb.newsblog.dto;

import java.util.List;
import java.util.stream.Collectors;


import edu.com.pweb.newsblog.model.Categoria;
import edu.com.pweb.newsblog.model.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@Getter
public class PostUpdate {
    private String titulo;
    private String texto;
    private Categoria categoria;

    public PostUpdate(Post post) {
        this.titulo = post.getTitulo();
        this.texto = post.getTexto();
        this.categoria = post.getCategoria();
    }


    public static List<PostUpdate> converte(List<Post> lista) {
        return lista.stream().map(PostUpdate::new).collect(Collectors.toList());        
    }
}
