package com.victornieto.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by victornc83 on 24/04/2017.
 */
@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "phone_numbers")
public class Telefono {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String numero;

    @ManyToMany(mappedBy = "phoneNumbers")
    private Set<Usuario> usuario;
}
