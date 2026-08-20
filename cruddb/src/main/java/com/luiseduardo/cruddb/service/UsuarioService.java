package com.luiseduardo.cruddb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luiseduardo.cruddb.entity.Usuario;
import com.luiseduardo.cruddb.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario cadastrar(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listar(){
        return usuarioRepository.findAll();
    }

    public Usuario procurar(long id){
        return procurarUsuario(id);
    }

    public Usuario alterarDados(long id, Usuario novosDados){
        Usuario usuario = procurar(id);
        usuario.setNome(novosDados.getNome());
        usuario.setEmail(novosDados.getEmail());

        return usuarioRepository.save(usuario);
    }

    public void apagarUsuario(long id){
        procurar(id);
        usuarioRepository.deleteById(id);
    }

    private Usuario procurarUsuario(long id){
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        if(optionalUsuario.isEmpty()){
            throw new RuntimeException("Usuário inexistente");
        }

        Usuario usuario = optionalUsuario.get();
        return usuario;
    }
}
