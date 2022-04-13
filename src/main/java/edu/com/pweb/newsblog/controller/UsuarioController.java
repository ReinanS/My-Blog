package edu.com.pweb.newsblog.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import edu.com.pweb.newsblog.dto.UsuarioIn;
import edu.com.pweb.newsblog.dto.UsuarioOut;
import edu.com.pweb.newsblog.service.UsuarioService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    
    final UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioOut>> list() {
        List<UsuarioOut> usuarios = usuarioService.listaAll();
        return new ResponseEntity<List<UsuarioOut>>(usuarios, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<UsuarioOut> findById(@PathVariable Long id) {
        UsuarioOut usuario = usuarioService.findById(id);
        return new ResponseEntity<UsuarioOut>(usuario, HttpStatus.OK);
    }

    // public ResponseEntity<UsuarioOut> cadastrar(@RequestBody UsuarioIn usuarioIn, UriComponentsBuilder builder) {
    // }



}
