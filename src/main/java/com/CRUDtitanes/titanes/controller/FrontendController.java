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


    //@GetMapping("/welcome")
    //public String getWelcome(Model model) {
    //    model.addAttribute("usuarios", gestorUsuario.getUsuarios());
    //    return "welcome";
    //}

}
