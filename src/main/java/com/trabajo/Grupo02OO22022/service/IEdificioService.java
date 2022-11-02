package com.trabajo.Grupo02OO22022.service;

import java.util.List;
import com.trabajo.Grupo02OO22022.entity.Edificio;

public interface IEdificioService {

    public List<Edificio> listaEdificios();;

    public Edificio buscarPorID(long id);

}
