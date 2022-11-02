package com.trabajo.Grupo02OO22022.repository;

import java.util.List;

import com.trabajo.Grupo02OO22022.entity.Tradicional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TradicionalRepository extends CrudRepository<Tradicional, Long> {

    List<Tradicional> findAll();
}
