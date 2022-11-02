package com.trabajo.Grupo02OO22022.repository;

import java.util.List;

import com.trabajo.Grupo02OO22022.entity.Role;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RoleRepository extends CrudRepository<Role, Long> {

    List<Role> findAll();

    List<Role> findByEnabledTrue();
}
