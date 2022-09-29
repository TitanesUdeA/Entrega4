package com.CRUDtitanes.titanes.service;


import com.CRUDtitanes.titanes.model.MovimientoDinero;
import com.CRUDtitanes.titanes.repository.MovimientoDineroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovimientoDineroService {
    @Autowired
    MovimientoDineroRepository movimientoDineroRepository;

    public void createMovimientoDinero(MovimientoDinero movimientoDinero){
        movimientoDineroRepository.save(movimientoDinero);
    }

    public List<MovimientoDinero> VerMovimientoDinero(){
        List<MovimientoDinero> movimientoDineros = new ArrayList<>();
        movimientoDineros.addAll(movimientoDineroRepository.findAll());
        return  movimientoDineros;
    }

    public void deleteMovimientoDinero(Long id){
        movimientoDineroRepository.deleteById(id);
    }

    public void editarMovimientoDinero(MovimientoDinero movimientoDinero){
        movimientoDineroRepository.save(movimientoDinero);
    }
}
