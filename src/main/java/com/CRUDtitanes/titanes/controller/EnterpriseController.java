package com.CRUDtitanes.titanes.controller;

import com.CRUDtitanes.titanes.model.Enterprise;
import com.CRUDtitanes.titanes.model.ObjetoRespuesta;
import com.CRUDtitanes.titanes.model.Usuario;
import com.CRUDtitanes.titanes.service.EnterpriseService;
import com.CRUDtitanes.titanes.service.EnterpriseServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EnterpriseController {
    @Autowired
    private EnterpriseServiceInterface enterpriseService;

    @GetMapping("/enterprises")
    private List<Enterprise> verEnterprise(){

        return enterpriseService.getEnterprises();
    }

    @PostMapping("/enterprise_parametro")
    private void createEnterprise(@RequestBody Enterprise enterprise){
        enterpriseService.setEnterprise(enterprise);
    }

    //@PutMapping("/enterprise/{id}")
    //public ResponseEntity<ObjetoRespuesta> putEnterprise(@RequestBody Enterprise enterprise_update, @PathVariable Long id){

    //    try {
    //        Enterprise enterprise_bd = enterpriseService.updateEnterpriseAll(enterprise_update, id);
    //        return new ResponseEntity<>(new ObjetoRespuesta("Actualización Exitosa", enterprise_bd ),HttpStatus.ACCEPTED);
    //    } catch (Exception e) {
    //        return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
    //    }
    //}

    @PatchMapping("/enterprise/{id}")
    public ResponseEntity<ObjetoRespuesta> patchEnterprise(@RequestBody Enterprise enterprise_update, @PathVariable Long id){

        try {
            Enterprise enterprise_bd = enterpriseService.updateEnterprise(enterprise_update, id);
            return new ResponseEntity<>(new ObjetoRespuesta("Actualización Exitosa",enterprise_bd),HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/enterprise/{id}")
    private void deleteEnterprise(@PathVariable("id") Long id){
        enterpriseService.deleteEnterprise(id);
    }


}
