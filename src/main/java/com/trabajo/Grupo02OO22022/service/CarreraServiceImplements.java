package com.trabajo.Grupo02OO22022.service;

import java.util.List;

import com.trabajo.Grupo02OO22022.entity.Carrera;
import com.trabajo.Grupo02OO22022.repository.CarreraRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Qualifier("carreraService")
@Service
public class CarreraServiceImplements implements ICarreraService {

    @Autowired
    private CarreraRepository CarreraRepository;

    @Override
    public List<Carrera> listaCarreras() {

        return (List<Carrera>) CarreraRepository.findAll();
    }

    @Override
    public void guardar(Carrera carrera) {
        CarreraRepository.save(carrera);
    }

    @Override
    public Carrera buscarPorID(long id) {
        return CarreraRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(long id) {
        CarreraRepository.deleteById(id);
    }

}
