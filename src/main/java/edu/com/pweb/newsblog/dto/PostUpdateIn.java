package edu.com.pweb.newsblog.dto;
import javax.validation.constraints.NotBlank;

import edu.com.pweb.newsblog.model.Categoria;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PostUpdateIn {

    @NotBlank
    private String titulo;

    @NotBlank
    private String texto;

    private Categoria categoria;
}
