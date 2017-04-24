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
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="product_id")
    private Producto producto;

    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Pedido pedido;
}
