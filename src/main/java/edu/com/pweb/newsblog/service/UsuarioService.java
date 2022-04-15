package edu.com.pweb.newsblog.service;

import java.util.List;
import java.util.NoSuchElementException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import org.modelmapper.ModelMapper;
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
    private final ModelMapper modelMapper;


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

    public UsuarioOut cadastrar(UsuarioIn usuarioIn) {
        Usuario usuario = modelMapper.map(usuarioIn, Usuario.class);
        usuario = repository.save(usuario);
        
        UsuarioOut usuarioOut = new UsuarioOut(usuario);

        return usuarioOut;
    }

    public UsuarioOut atualizar(Long id, UsuarioIn usuarioIn) {
        UsuarioOut usuarioOut = null;

        try {
            Usuario usuario = repository.getById(id);

            usuario.setNome(usuarioIn.getNome());
            usuario.setLogin(usuarioIn.getLogin());
            usuario.setPassword(usuarioIn.getPassword());

            usuarioOut = new UsuarioOut(usuario);

        } catch (NoSuchElementException exception) {
            System.out.println("OCORREU UMA EXCESSÃO, USUARIO INEXISTENTE");
            throw new ResponseStatusException(NOT_FOUND);
        }

        return usuarioOut;
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

}
