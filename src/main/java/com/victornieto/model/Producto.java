package com.victornieto.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by victornc83 on 24/04/2017.
 */
@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "products")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String nombre ;
}
