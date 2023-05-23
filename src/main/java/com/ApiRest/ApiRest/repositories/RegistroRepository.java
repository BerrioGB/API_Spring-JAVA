package com.ApiRest.ApiRest.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ApiRest.ApiRest.models.UsuarioModel;

@Repository
public interface RegistroRepository extends JpaRepository<UsuarioModel, Long> {

}
