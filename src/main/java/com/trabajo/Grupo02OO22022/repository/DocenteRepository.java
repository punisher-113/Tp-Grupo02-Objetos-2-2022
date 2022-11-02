package com.trabajo.Grupo02OO22022.repository;

import com.trabajo.Grupo02OO22022.entity.Docente;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocenteRepository extends CrudRepository<Docente, Long> {

}
