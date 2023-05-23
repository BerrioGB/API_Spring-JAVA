package com.ApiRest.ApiRest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class RutasController {
    @GetMapping("/")
    public String principalPage(){
        return "index.html";
    }
    @GetMapping("/registrar")
    public String paginaInicio(){
        return "inicio";
    }
}