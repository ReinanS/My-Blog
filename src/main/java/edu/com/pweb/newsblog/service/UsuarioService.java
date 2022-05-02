package edu.com.pweb.newsblog.service;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import edu.com.pweb.newsblog.dto.UsuarioIn;
import edu.com.pweb.newsblog.dto.UsuarioOut;
import edu.com.pweb.newsblog.model.Usuario;
import edu.com.pweb.newsblog.respository.UsuarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository repository;
    private final ModelMapper modelMapper;

    public List<UsuarioOut> listaAll() {
        return UsuarioOut.converte(repository.findAll());
    }

    public Page<UsuarioOut> list(Pageable pageable) {
        return UsuarioOut.converteFromPage(repository.findAll(pageable));
    }

    public Usuario findByIdOrThrowNotFoundRequestException(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Usuário not Found"));
    }

    public UsuarioOut findById(Long id) {
        return new UsuarioOut(findByIdOrThrowNotFoundRequestException(id));
    }

    public UsuarioOut cadastrar(UsuarioIn usuarioIn) {
        Usuario usuario = modelMapper.map(usuarioIn, Usuario.class);
        usuario = repository.save(usuario);
        
        return new UsuarioOut(usuario);
    }

    public void atualizar(Long id, UsuarioIn usuarioIn) {
    //    Usuario savedUsuario = findByIdOrThrowNotFoundRequestException(id);
    //    Usuario usuario = new Usuario(savedUsuario.getId(), usuarioIn.getNome(), usuarioIn.getLogin(), usuarioIn.getPassword());
       
    //    repository.save(usuario);
    }

    public void deletar(Long id) {
        // NECESSÁRIO VALIDAÇÃO PARA QUANDO O USUÁRIO ESTIVER ASSOCIADO A ALGUM POST

        repository.delete(findByIdOrThrowNotFoundRequestException(id));
    }
}
