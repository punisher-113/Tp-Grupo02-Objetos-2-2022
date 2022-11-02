package com.trabajo.Grupo02OO22022.service;

import java.util.List;
import com.trabajo.Grupo02OO22022.entity.Carrera;

public interface ICarreraService {

    public List<Carrera> listaCarreras();

    public void guardar(Carrera carrera);

    public Carrera buscarPorID(long id);

    public void eliminar(long id);

}
