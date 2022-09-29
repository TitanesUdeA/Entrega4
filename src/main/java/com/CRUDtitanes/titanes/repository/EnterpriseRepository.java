package com.CRUDtitanes.titanes.repository;

import com.CRUDtitanes.titanes.model.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EnterpriseRepository extends JpaRepository<Enterprise, Long> {
    @Modifying
    @Query("UPDATE Enterprise en SET en.nombre= :nombre, en.direccion= :direccion, en.telefono= :telefono, en.nit= :nit WHERE en.id= :id")
    public int update(String nombre, String direccion, String telefono, String nit);
}
