package com.trabajo.Grupo02OO22022.service;

import java.util.List;

import com.trabajo.Grupo02OO22022.entity.Curso;
import com.trabajo.Grupo02OO22022.entity.Final;
import com.trabajo.Grupo02OO22022.entity.NotaPedido;

public interface INotaPedidoService {

    public List<NotaPedido> listarTodos();

    public List<Final> getAll();

    public List<Curso> getAll1();

    public Final insertOrUpdate(Final final1);

    public Curso insertOrUpdateCurso(Curso curso);

    public void guardar(NotaPedido notaPedido);

    public void eliminarFinal(long id);

    public void eliminarCurso(long id);

    public Final buscarPorID(long id);

    public Curso buscarPorIDCurso(long id);

}
