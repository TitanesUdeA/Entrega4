package com.CRUDtitanes.titanes.controller;


import com.CRUDtitanes.titanes.model.MovimientoDinero;
import com.CRUDtitanes.titanes.service.MovimientoDineroService;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovimientoDineroController {

    final
    MovimientoDineroService movimientoDineroService;

    public MovimientoDineroController(MovimientoDineroService movimientoDineroService) {
        this.movimientoDineroService = movimientoDineroService;
    }

    @PostMapping("/movimientoDinero")
    private void createMovimientoDinero(@RequestBody MovimientoDinero movimientoDinero){
        movimientoDineroService.createMovimientoDinero(movimientoDinero);
    }

    @GetMapping("/movimientoDinero")
    private List<MovimientoDinero> verMovimientoDinero(){
        return movimientoDineroService.VerMovimientoDinero();
    }

    @DeleteMapping("/movimientoDinero/{id}")
    private void deleteMovimientoDinero(@PathVariable("id") Long id){ movimientoDineroService.deleteMovimientoDinero(id);}

    @PatchMapping("/movimientoDinero")
    private void editarMovimientoDinero(@RequestBody MovimientoDinero movimientoDinero){movimientoDineroService.editarMovimientoDinero(movimientoDinero);}
}
