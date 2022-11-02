package com.trabajo.Grupo02OO22022.service;

import java.util.List;

import com.trabajo.Grupo02OO22022.entity.Departamento;

public interface IDepartamentoService {

    public List<Departamento> listarTodos();

    public Departamento buscarPorID(long id);

    public void guardar(Departamento departamento);

}
