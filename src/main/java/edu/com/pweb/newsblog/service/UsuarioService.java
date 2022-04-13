package edu.com.pweb.newsblog.service;

import java.util.List;
import java.util.NoSuchElementException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import edu.com.pweb.newsblog.dto.UsuarioIn;
import edu.com.pweb.newsblog.dto.UsuarioOut;
import edu.com.pweb.newsblog.model.Usuario;
import edu.com.pweb.newsblog.respository.UsuarioRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UsuarioService {
    private final UsuarioRepository repository;

    public List<UsuarioOut> listaAll() {
        return UsuarioOut.converte(repository.findAll());
    }

    public UsuarioOut findById(Long id) {
        UsuarioOut usuarioOut = null;

        try {
            Usuario usuario = repository.findById(id).get();
            usuarioOut = new UsuarioOut(usuario);

        } catch (NoSuchElementException exception) {
            System.out.println("OCORREU UMA EXCESSÃO, USUARIO INEXISTENTE");
            throw new ResponseStatusException(NOT_FOUND);
        }

        return usuarioOut;
    }

    // public UsuarioOut cadastrar(UsuarioIn usuarioIn) {
    //     UsuarioOut usuario = UsuarioOut.converteIn(usuarioIn);

    //     return UsuarioOut.converte(repository.sav)
    // }




}
