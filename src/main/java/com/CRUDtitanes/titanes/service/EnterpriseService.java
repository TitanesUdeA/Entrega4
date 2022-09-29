package com.CRUDtitanes.titanes.service;

import com.CRUDtitanes.titanes.model.Enterprise;
import com.CRUDtitanes.titanes.repository.EnterpriseRepository;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EnterpriseService implements EnterpriseServiceInterface {

    @Autowired
    private EnterpriseRepository enterpriseRepository;


    @Override
    public List<Enterprise> getEnterprises() {
        return enterpriseRepository.findAll();
    }

    @Override
    public Enterprise getEnterprise(Long id) throws Exception {
        Optional<Enterprise> enterpriseBd = enterpriseRepository.findById(id);
        if(enterpriseBd.isPresent()){
            return enterpriseBd.get();
        }
        throw new Exception("Usuario No Existe");
    }

    @Override
    public String setEnterprise(Enterprise enterprise_parametro) {
        enterpriseRepository.save(enterprise_parametro);
        return "Empresa creada con éxito";
    }

    @Transactional
    @Override
    public Enterprise updateEnterpriseAll(Enterprise enterprise_update, Long id) throws Exception {
        enterpriseRepository.update(enterprise_update.getNombre(), enterprise_update.getDireccion(), enterprise_update.getTelefono(), enterprise_update.getNit());
        return getEnterprise(id);
    }

    @Override
    public Enterprise updateEnterprise(Enterprise enterprise_update, Long id) {
        return null;
    }

    @Override
    public String deleteEnterprise(Long id) {
        enterpriseRepository.deleteById(id);
        return "Empresa borrada exitosamente";
    }

    //Metodos
    //public void create_UpdateEnterprise(Enterprise enterprise){

      //  enterpriseRepository.save(enterprise);
    //}

    //public List<Enterprise> verEnterprise(){
      //  List<Enterprise> enterprises = new ArrayList<>();
        //enterprises.addAll(enterpriseRepository.findAll());
        //return enterprises;
    //}
    //public void deleteEnterprise(Long id){
      //  enterpriseRepository.deleteById(id);
    //}


}
