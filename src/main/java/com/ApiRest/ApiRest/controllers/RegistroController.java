package com.ApiRest.ApiRest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;
import com.ApiRest.ApiRest.models.UsuarioModel;
import com.ApiRest.ApiRest.repositories.RegistroRepository;

@RestController
@RequestMapping("/registrar")
public class RegistroController {
    private final RegistroRepository registroRepository;

    @Autowired
    public RegistroController(RegistroRepository registroRepository){
        this.registroRepository = registroRepository;
    }

    @PostMapping()
    public RedirectView createUser(@RequestParam("nombre") String nombre,@RequestParam("email") String email, @RequestParam("contrasena") String contrasena){
        UsuarioModel usuario = new UsuarioModel();
        usuario.setEmail(email);
        usuario.setNombre(nombre);
        usuario.setContrasena(Hashing.sha256().hashString(contrasena, StandardCharsets.UTF_8).toString());

        

        registroRepository.save(usuario);

        return new RedirectView("registrar");
    }

}
