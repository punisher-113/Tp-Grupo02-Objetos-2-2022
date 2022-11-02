package com.trabajo.Grupo02OO22022.service;

import java.util.List;

import com.trabajo.Grupo02OO22022.entity.Persona;

public interface IPersonaService {

    public List<Persona> listarTodos();

    public Persona buscarPorID(long id);

    public Persona buscarPorDni(long dni);

    public void guardar(Persona user);

    public List<Persona> listarDni(Long dni);

}
