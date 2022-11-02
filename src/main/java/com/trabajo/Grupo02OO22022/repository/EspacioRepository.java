package com.trabajo.Grupo02OO22022.repository;

import java.util.List;

import com.trabajo.Grupo02OO22022.entity.Espacio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EspacioRepository extends CrudRepository<Espacio, Long> {

    List<Espacio> findAll();

    List<Espacio> findByLibreTrue();
}
