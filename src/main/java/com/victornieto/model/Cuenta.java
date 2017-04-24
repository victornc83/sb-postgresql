package com.victornieto.model;

import lombok.*;

import javax.persistence.*;

/**
 * Created by victornc83 on 24/04/2017.
 */
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "accounts")
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String codigo;

    private String descripcion;
}
