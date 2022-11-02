package com.trabajo.Grupo02OO22022.service;

import java.util.List;
import com.trabajo.Grupo02OO22022.entity.Materia;

public interface IMateriaService {

    public List<Materia> listaMaterias();

    public void guardar(Materia materia);

    public Materia buscarPorID(long id);

    public void eliminar(long id);

}
