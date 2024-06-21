package com.antoni.proyectodamdietas.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.antoni.proyectodamdietas.modelo.*;
import com.antoni.proyectodamdietas.service.*;

@Controller
public class HomeController {

    @Autowired
    private DietaService dietaService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/dietas")
    public String viewDietas(Model model) {
        List<Dieta> dietas = dietaService.getAllDietas();
        model.addAttribute("dietas", dietas);
        return "dieta_list";
    }

    @GetMapping("/comida/{id}")
    public String viewComida(@PathVariable int id, Model model) {
        Comida comida = dietaService.getComidaById(id);
        model.addAttribute("comida", comida);
        return "comida_detail";
    }
}
