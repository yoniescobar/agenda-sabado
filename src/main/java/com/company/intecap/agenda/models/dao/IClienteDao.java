package com.company.intecap.agenda.models.dao;

import com.company.intecap.agenda.models.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IClienteDao extends JpaRepository<Cliente, Long> {
    //este medetodo para consultar la existencia de un cliente
    Optional<Cliente> findByNombre(String nombre);
}
