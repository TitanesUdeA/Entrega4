package com.CRUDtitanes.titanes.repository;

import com.CRUDtitanes.titanes.model.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoDineroRepository extends JpaRepository<MovimientoDinero, Long> {
}
