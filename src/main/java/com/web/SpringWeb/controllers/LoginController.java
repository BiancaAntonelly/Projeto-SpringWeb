package com.web.SpringWeb.controllers;

import com.web.SpringWeb.models.Administrador;
import com.web.SpringWeb.models.Model;
import com.web.SpringWeb.repository.AdministradoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    private final AdministradoresRepository administradoresRepository;

    @Autowired
    public LoginController(AdministradoresRepository administradoresRepository) {
        this.administradoresRepository = administradoresRepository;
    }
    @GetMapping("/login")
    public String index(){
        return "login/index";
    }

    @PostMapping("/logar")
    public String logar(Model model, Administrador admParam, String lembrar){

        Administrador adm = this.administradoresRepository.Login(admParam.getEmail(), admParam.getSenha());
        if (adm != null) {
            return "redirect:/";
        }

        model.addAttribute("erro", "Usuário ou senha inválidos");
        return "login/index";
    }
}
