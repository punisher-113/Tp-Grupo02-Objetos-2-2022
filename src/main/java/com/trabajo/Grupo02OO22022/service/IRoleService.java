package com.trabajo.Grupo02OO22022.service;

import java.util.List;
import com.trabajo.Grupo02OO22022.entity.Role;

public interface IRoleService {

    public List<Role> listaRoles();

    public List<Role> listarActivos();

    public void guardar(Role role);

    public Role buscarPorID(long id);

    public void eliminar(long id);

}
