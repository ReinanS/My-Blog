package edu.com.pweb.newsblog.dto;

import java.util.List;
import java.util.stream.Collectors;

import edu.com.pweb.newsblog.model.Usuario;
import lombok.Getter;

@Getter
public class UsuarioOut {
    private Long id;
    private String nome;

    public UsuarioOut(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
    }

    public UsuarioOut(UsuarioIn usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
    }

    public static List<UsuarioOut> converte(List<Usuario> lista) {
        return lista.stream().map(UsuarioOut::new).collect(Collectors.toList());
    }

    public static List<UsuarioOut> converteIn(List<UsuarioIn> lista) {
        return lista.stream().map(UsuarioOut::new).collect(Collectors.toList());
    }
}
