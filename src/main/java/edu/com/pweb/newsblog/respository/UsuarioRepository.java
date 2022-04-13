package edu.com.pweb.newsblog.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.com.pweb.newsblog.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
}
