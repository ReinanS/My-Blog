package edu.com.pweb.newsblog.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import edu.com.pweb.newsblog.model.Usuario;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class UsuarioOut {
    private Long id;
    private String nome;

    public UsuarioOut(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
    }
    
    public static List<UsuarioOut> converte(List<Usuario> lista) {
        return lista.stream().map(UsuarioOut::new).collect(Collectors.toList());
    }

    public static Page<UsuarioOut> converteFromPage(Page<Usuario> page) {
        return page.map(UsuarioOut::new);
    }
}
