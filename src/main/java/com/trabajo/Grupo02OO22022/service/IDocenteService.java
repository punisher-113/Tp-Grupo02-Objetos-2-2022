package com.trabajo.Grupo02OO22022.service;

import java.util.List;

import com.trabajo.Grupo02OO22022.entity.Docente;

public interface IDocenteService {

    public List<Docente> listarTodos();

    public void guardar(Docente docente);

    public Docente buscarPorID(long id);

    public void eliminar(long id);

}
