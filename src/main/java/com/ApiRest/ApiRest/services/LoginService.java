package com.ApiRest.ApiRest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ApiRest.ApiRest.models.UsuarioModel;
import com.ApiRest.ApiRest.repositories.LogeadosRepository;

@Service
public class LoginService {
    private final LogeadosRepository logeadosRepository;

    @Autowired
    public LoginService(LogeadosRepository logeadosRepository){
        this.logeadosRepository = logeadosRepository;
    }

    public UsuarioModel findByEmail(String email){
        return logeadosRepository.findByEmail(email);
    }
}
