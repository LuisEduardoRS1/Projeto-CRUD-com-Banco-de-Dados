package com.luiseduardo.cruddb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luiseduardo.cruddb.entity.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
}
