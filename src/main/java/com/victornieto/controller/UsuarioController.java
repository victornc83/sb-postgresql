package com.victornieto.controller;

import com.victornieto.model.Usuario;
import com.victornieto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by victornc83 on 21/04/2017.
 */
@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository ;

    @RequestMapping("/")
    public List<Usuario> getUsuarios() {
        return (List<Usuario>) repository.findAll();
    }

    @RequestMapping("/buscar/id/{id}")
    public Usuario getUsuariosById(@PathVariable Long id){
        return repository.findById(id) ;
    }

    @RequestMapping("/buscar/nombre/{name}")
    public List<Usuario> getUsuariosByNombre(@PathVariable String nombre) {
        return repository.findByNombre(nombre) ;
    }

    @RequestMapping("/buscar/apellido/{ap}")
    public List<Usuario> getUsuariosByApellido(@PathVariable String ap) {
        return repository.findByApellido(ap) ;
    }

    @PostMapping("/add")
    public Usuario addUsuario(@RequestBody Usuario user) {
        return repository.save(user) ;
    }

    @DeleteMapping("/del")
    public ResponseEntity delUsuario(@RequestBody Usuario user) {
        try {
            repository.delete(user);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity updateUsuario(@RequestBody Usuario user) {
        repository.save(user) ;
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
