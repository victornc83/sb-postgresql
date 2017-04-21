package com.victornieto.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by victornc83 on 21/04/2017.
 */
@Entity
@Table(name="users")
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private String nombre ;
    private String apellidos ;
    private String password ;
}
