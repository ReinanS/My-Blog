package edu.com.pweb.newsblog.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "posts")
public class Post {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String titulo;

    @NotBlank
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
