package com.victornieto.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by victornc83 on 24/04/2017.
 */
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt ;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario ;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.EAGER, mappedBy = "pedido")
    private List<Item> items;
}
