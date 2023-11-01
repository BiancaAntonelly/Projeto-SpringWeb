package com.web.SpringWeb.controllers;

import com.web.SpringWeb.models.Administrador;
import com.web.SpringWeb.repository.AdministradoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdministradoresController {


    private final AdministradoresRepository administradoresRepository;

    @Autowired
    public AdministradoresController(AdministradoresRepository administradoresRepository) {
        this.administradoresRepository = administradoresRepository;
    }
    @GetMapping("/administradores")
    public String index(Model model){
        List<Administrador> administradores = (List<Administrador>)administradoresRepository.findAll();
        model.addAttribute("administradores", administradores);
        return "administradores/index";
    }
    @GetMapping("/administradores/novo")
    public String novo(){
      return "administradores/novo";
    }
}
