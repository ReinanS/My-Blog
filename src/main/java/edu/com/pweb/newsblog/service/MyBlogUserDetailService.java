package edu.com.pweb.newsblog.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.com.pweb.newsblog.respository.UsuarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MyBlogUserDetailService implements UserDetailsService{
    
    final UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return Optional.ofNullable(usuarioRepository.findByLogin(username))
        .orElseThrow(() -> new UsernameNotFoundException("User not found"));    
    }
}
