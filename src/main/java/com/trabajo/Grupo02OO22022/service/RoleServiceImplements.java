package com.trabajo.Grupo02OO22022.service;

import java.util.List;

import com.trabajo.Grupo02OO22022.entity.Role;
import com.trabajo.Grupo02OO22022.repository.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Qualifier("roleService")
@Service
public class RoleServiceImplements implements IRoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> listaRoles() {

        return (List<Role>) roleRepository.findAll();
    }

    @Override
    public void guardar(Role role) {
        roleRepository.save(role);
    }

    @Override
    public Role buscarPorID(long id) {
        return roleRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public List<Role> listarActivos() {
        return (List<Role>) roleRepository.findByEnabledTrue();
    }

}
