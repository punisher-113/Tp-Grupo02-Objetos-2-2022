package com.trabajo.Grupo02OO22022.service;

import java.time.LocalDate;
import java.util.List;

import com.trabajo.Grupo02OO22022.entity.Aula;
import com.trabajo.Grupo02OO22022.entity.Espacio;

public interface IEspacioService {

    public List<Espacio> listaEspacios();

    public List<Espacio> listarActivos();

    public void guardar(Espacio espacio);

    public Espacio buscarPorID(long id);

    public void eliminar(long id);

    public Espacio traerEspacio(LocalDate fecha, char turno, Aula aula);

    public void agregarEspacioMes(int mes, int anio, char turno, Aula aula);

}
