package com.CRUDtitanes.titanes.model;

import lombok.*;
import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

@Table(name="transacciones")
public class MovimientoDinero {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String concept;
    @Column
    private float amount;

    @ManyToOne
    @JoinColumn(name = "usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "enterprise")
    private Enterprise enterprise;



}