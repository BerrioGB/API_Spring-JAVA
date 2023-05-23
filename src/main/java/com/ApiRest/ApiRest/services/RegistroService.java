package com.ApiRest.ApiRest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ApiRest.ApiRest.models.UsuarioModel;
import com.ApiRest.ApiRest.repositories.RegistroRepository;

@Service
public class RegistroService {
    RegistroRepository registroRepository;

    @Autowired

    public RegistroService(RegistroRepository registroRepository){
        this.registroRepository = registroRepository;
    }

    public UsuarioModel registrarUsuario(UsuarioModel usuario){
        return registroRepository.save(usuario);
    }
}
