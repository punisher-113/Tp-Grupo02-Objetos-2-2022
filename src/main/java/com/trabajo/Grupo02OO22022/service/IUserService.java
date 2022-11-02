package com.trabajo.Grupo02OO22022.service;

import java.util.List;

import com.trabajo.Grupo02OO22022.entity.User;

public interface IUserService {

    public List<User> listarTodos();

    public List<User> listarActivos();

    public void guardar(User user);

    public User buscarPorID(long id);

    public void eliminar(long id);

}
