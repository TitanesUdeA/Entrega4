package com.CRUDtitanes.titanes.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="enterprise")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Enterprise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    //Atributos
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "nit")
    private String nit;

    @OneToMany(mappedBy="enterprise")
    private List<MovimientoDinero> movimientoDineros;

}