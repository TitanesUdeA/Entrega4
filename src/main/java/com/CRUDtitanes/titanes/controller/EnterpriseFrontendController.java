package com.CRUDtitanes.titanes.controller;

import com.CRUDtitanes.titanes.model.Usuario;
import com.CRUDtitanes.titanes.service.EnterpriseServiceInterface;
import com.CRUDtitanes.titanes.service.GestorUsuarioInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EnterpriseFrontendController {

    @Autowired
    private EnterpriseServiceInterface enterpriseServiceInterface;

    //@GetMapping("/login")
    //public String getLogin(Model model){
    //    model.addAttribute("formUsuario", new Usuario());
    //    return "login";
    //}

    //En welcome aparecerá la lista de empresas creadas:
    @GetMapping("/welcome")
    public String getWelcome(Model model) {
        model.addAttribute("enterprises", enterpriseServiceInterface.getEnterprises());
        return "welcome";
    }

}
