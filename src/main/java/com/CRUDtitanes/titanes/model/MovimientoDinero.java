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

public class MovimientoDinero {
    private String concept;
    private float amount;
    private String usuario;
    private Long id;


    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }
}
