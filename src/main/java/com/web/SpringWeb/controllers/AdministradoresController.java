package com.web.SpringWeb.controllers;

import com.web.SpringWeb.models.Administrador;
import com.web.SpringWeb.repository.AdministradoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

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
    @GetMapping("/administradores/{id}/excluir")
    public String excluir(@PathVariable int id){
        administradoresRepository.deleteById(id);
        return "redirect:/administradores";
    }
    @GetMapping("/administradores/{id}")
    public String busca(@PathVariable int id, Model model){
        Optional<Administrador> admin = administradoresRepository.findById(id);

        try{
            model.addAttribute("administrador", admin.get());
        }catch (Exception err){ return "redirect:/administradores";}

        return "/administradores/editar";
    }

    @PostMapping("/administradores/{id}/alterar")
    public String alterar(@PathVariable int id, Administrador administrador){
        if (!administradoresRepository.existsById(id)){
            return "redirect:/administradores";
        }
        administradoresRepository.save(administrador);

        return "redirect:/administradores";

    }
}
