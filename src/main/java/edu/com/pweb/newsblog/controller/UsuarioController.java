package edu.com.pweb.newsblog.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import edu.com.pweb.newsblog.dto.UsuarioIn;
import edu.com.pweb.newsblog.dto.UsuarioOut;
import edu.com.pweb.newsblog.service.UsuarioService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    
    final UsuarioService usuarioService;

    @ApiOperation(value = "Retorna todos os usuários")
    @GetMapping
    public ResponseEntity<List<UsuarioOut>> list() {
        List<UsuarioOut> usuarios = usuarioService.listaAll();
        return new ResponseEntity<List<UsuarioOut>>(usuarios, HttpStatus.OK);
    }

    @ApiOperation(value = "Salva um usuário")
    @PostMapping
    public ResponseEntity<UsuarioOut> cadastrar(@Valid @RequestBody UsuarioIn usuarioIn, UriComponentsBuilder builder) {
        UsuarioOut usuarioOut = usuarioService.cadastrar(usuarioIn);
        return new ResponseEntity<UsuarioOut>(usuarioOut, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Retorna um usuário por id")
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioOut> findById(@Valid @PathVariable Long id) {
        UsuarioOut usuario = usuarioService.findById(id);
        return new ResponseEntity<UsuarioOut>(usuario, HttpStatus.OK);
    }

    @ApiOperation(value = "Atualiza um usuário")
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody UsuarioIn usuarioIn) {
       usuarioService.atualizar(id, usuarioIn);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "Deleta um usuário por id")
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        usuarioService.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
