package com.ApiRest.ApiRest.controllers;

import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.ApiRest.ApiRest.models.UsuarioModel;
import com.ApiRest.ApiRest.services.LoginService;
import com.google.common.hash.Hashing;

@Controller
public class LoginController {
    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService){
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public RedirectView processLogin(@RequestParam("email") String email, @RequestParam("contrasena") String contrasena, RedirectAttributes redirectAttributes){
        UsuarioModel login = loginService.findByEmail(email);

        if(login == null){
            redirectAttributes.addFlashAttribute("error", "User Dont Find");
            return new RedirectView("/");
        }

        String storedPasswordHash = login.getContrasena();
        String passwordHash = Hashing.sha256().hashString(contrasena, StandardCharsets.UTF_8).toString();

        if (login != null && passwordHash.equals(storedPasswordHash)) {
            return new RedirectView("/registrar");
        } else {
            redirectAttributes.addFlashAttribute("error", "Credenciales inválidas");
            return new RedirectView("/");

        }
    }
}
