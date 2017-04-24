package com.victornieto.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by victornc83 on 21/04/2017.
 */
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database generated User ID")
    private Long id ;
    @ApiModelProperty(notes = "Username")
    private String nombre ;
    @ApiModelProperty(notes = "Surname")
    private String apellidos ;
    @ApiModelProperty(notes = "User's password")
    private String password ;
    @ApiModelProperty(notes = "Address")
    private String direccion ;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="customers_phones")
    private Set<Telefono> phoneNumbers;
}
