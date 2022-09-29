package com.CRUDtitanes.titanes.controller;

import com.CRUDtitanes.titanes.model.Usuario;
import com.CRUDtitanes.titanes.service.GestorUsuarioInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FrontendController {

    @Autowired
    private GestorUsuarioInterface gestorUsuario;

    @GetMapping("/login")
    public String getLogin(Model model){
        model.addAttribute("formUsuario", new Usuario());
        return "login";
    }

    //Cuando el usuario hace login, se despliega el listado de empresas:
    @GetMapping("/welcome")
    public String getWelcome(Model model){
        return "welcome";
    }

}
