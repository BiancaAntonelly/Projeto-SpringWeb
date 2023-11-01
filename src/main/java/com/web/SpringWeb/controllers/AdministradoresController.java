package com.web.SpringWeb.controllers;

import com.web.SpringWeb.models.Administrador;
import com.web.SpringWeb.repository.AdministradoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
    @PostMapping("/administradores/criar")
    public String criar(Administrador criarAdministrador){
        administradoresRepository.save(criarAdministrador);
        return "redirect:/administradores";
    }
    @GetMapping("/administradores{id}/excluir")
    public String excluir(@PathVariable int id){
        administradoresRepository.deleteById(id);
        return "redirect:/administradores";
    }
}
