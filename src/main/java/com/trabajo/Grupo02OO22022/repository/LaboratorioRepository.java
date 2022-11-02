package com.trabajo.Grupo02OO22022.repository;

import java.util.List;

import com.trabajo.Grupo02OO22022.entity.Laboratorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface LaboratorioRepository extends CrudRepository<Laboratorio, Long> {

    List<Laboratorio> findAll();
}
