package edu.com.pweb.newsblog.dto;

import javax.validation.constraints.NotBlank;

import edu.com.pweb.newsblog.model.Categoria;
import lombok.Getter;

@Getter
public class PostIn {

    @NotBlank
    private String titulo;

    @NotBlank
    private String texto;

    @NotBlank
    private String idUsuario;

    private Categoria categoria;
}
