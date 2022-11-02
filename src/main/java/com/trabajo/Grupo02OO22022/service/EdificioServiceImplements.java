package com.trabajo.Grupo02OO22022.service;

import java.util.List;

import com.trabajo.Grupo02OO22022.entity.Edificio;
import com.trabajo.Grupo02OO22022.repository.EdificioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Qualifier("edificioService")
@Service
public class EdificioServiceImplements implements IEdificioService {

    @Autowired
    private EdificioRepository EdificioRepository;

    @Override
    public List<Edificio> listaEdificios() {

        return (List<Edificio>) EdificioRepository.findAll();
    }

    @Override
    public Edificio buscarPorID(long id) {
        return EdificioRepository.findById(id).orElse(null);
    }

}
