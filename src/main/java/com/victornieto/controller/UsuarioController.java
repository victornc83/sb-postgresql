package com.victornieto.controller;

import com.victornieto.model.Usuario;
import com.victornieto.repository.UsuarioRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    @ApiOperation(value = "Show full list of Users")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/")
    public List<Usuario> getUsuarios() {
        return (List<Usuario>) repository.findAll();
    }

    @ApiOperation(value = "Find User by ID")
    @GetMapping("/buscar/id/{id}")
    public Usuario getUsuariosById(@PathVariable Long id){
        return repository.findById(id) ;
    }

    @ApiOperation(value = "Find User by Name")
    @GetMapping("/buscar/nombre/{name}")
    public List<Usuario> getUsuariosByNombre(@PathVariable String nombre) {
        return repository.findByNombre(nombre) ;
    }

    @ApiOperation(value = "Find User by Surname")
    @GetMapping("/buscar/apellido/{ap}")
    public List<Usuario> getUsuariosByApellido(@PathVariable String ap) {
        return repository.findByApellidos(ap) ;
    }

    @ApiOperation(value = "Add new user")
    @PostMapping("/add")
    public Usuario addUsuario(@RequestBody Usuario user) {
        return repository.save(user) ;
    }

    @ApiOperation(value = "Delete user")
    @DeleteMapping("/del")
    public ResponseEntity delUsuario(@RequestBody Usuario user) {
        try {
            repository.delete(user);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation(value = "Update any field in a saved user")
    @PutMapping("/update")
    public ResponseEntity updateUsuario(@RequestBody Usuario user) {
        repository.save(user) ;
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
