package com.trabajo.Grupo02OO22022.service;

import java.util.List;
import com.trabajo.Grupo02OO22022.entity.Aula;
import com.trabajo.Grupo02OO22022.entity.Laboratorio;
import com.trabajo.Grupo02OO22022.entity.Tradicional;

public interface IAulaService {

    public List<Aula> listaAulas();

    public void guardar(Aula aula);

    public Tradicional buscarPorID(long id);

    public Laboratorio buscarPorIDLab(long id);

}
