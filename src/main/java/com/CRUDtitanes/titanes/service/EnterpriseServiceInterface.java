package com.CRUDtitanes.titanes.service;

import com.CRUDtitanes.titanes.model.Enterprise;

import java.util.List;

public interface EnterpriseServiceInterface {

    public List<Enterprise> getEnterprises();
    public Enterprise getEnterprise(Long id) throws Exception;
    public String setEnterprise(Enterprise enterprise_parametro);
    public Enterprise updateEnterpriseAll(Enterprise enterprise_update, Long id) throws Exception;
    public Enterprise updateEnterprise(Enterprise enterprise_update, Long id);
    public String deleteEnterprise(Long id);

}
