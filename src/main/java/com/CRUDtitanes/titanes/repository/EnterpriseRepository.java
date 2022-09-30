package com.CRUDtitanes.titanes.repository;

import com.CRUDtitanes.titanes.model.Enterprise;
import com.CRUDtitanes.titanes.model.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnterpriseRepository extends JpaRepository<Enterprise, Long> {
    //@Modifying
    //@Query("UPDATE Enterprise en SET en.nombre= :nombre, en.direccion= :direccion, en.telefono= :telefono, en.nit= :nit, en.movimientodineros= :movimientodineros WHERE en.id= :id")
    //public int update(String nombre, String direccion, String telefono, String nit, List<MovimientoDinero> movimientoDineros);
}
