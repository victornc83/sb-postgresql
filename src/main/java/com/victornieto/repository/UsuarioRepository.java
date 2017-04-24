package com.victornieto.repository;

import com.victornieto.model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by victornc83 on 21/04/2017.
 */
@RepositoryRestResource(collectionResourceRel = "usuario")
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    Usuario findById(Long id) ;
    List<Usuario> findByNombre(String nombre) ;
    List<Usuario> findByApellidos(String apellido) ;
}
