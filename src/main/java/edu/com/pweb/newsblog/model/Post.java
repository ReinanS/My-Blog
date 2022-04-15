package edu.com.pweb.newsblog.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "posts")
public class Post {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String texto;

    @ManyToOne
    private Usuario usuario;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    public Post(String titulo, String texto, Usuario usuario, Categoria categoria) {
        this.titulo = titulo;
        this.texto = texto;
        this.usuario = usuario;
        this.categoria = categoria;
    }
}
