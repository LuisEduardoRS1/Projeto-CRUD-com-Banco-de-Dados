package com.luiseduardo.cruddb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luiseduardo.cruddb.entity.Usuario;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;
    

    @PostMapping()
    public Usuario cadastrar(@RequestBody Usuario usuario) {
        return usuarioService.cadastrar(usuario);
    }

    @GetMapping
    public List<Usuario> listar(){
        return usuarioService.listar();
    }

    @PutMapping("/{id}")
    public Usuario alterarDados(@PathVariable long id, @RequestBody Usuario usuario){
        return usuarioService.alterarDados(id, usuario);
    }

    @DeleteMapping("/{id}")
    public void apagarUsuario(@PathVariable long id){
        usuarioService.apagarUsuario(id);
    }
    
}
