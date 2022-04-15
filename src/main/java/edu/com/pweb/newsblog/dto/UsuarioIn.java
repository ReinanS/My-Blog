package edu.com.pweb.newsblog.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Getter;

@Getter
public class UsuarioIn {

    @NotBlank
    private String nome;

    @NotBlank @Email
    private String login;

    @NotBlank
    private String password;
}
