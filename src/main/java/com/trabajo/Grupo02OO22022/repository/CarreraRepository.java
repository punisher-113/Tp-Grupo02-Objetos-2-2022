package com.trabajo.Grupo02OO22022.repository;

import java.util.List;

import com.trabajo.Grupo02OO22022.entity.Carrera;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CarreraRepository extends CrudRepository<Carrera, Long> {

    List<Carrera> findAll();
}
