package com.trabajo.Grupo02OO22022.service;

import java.util.List;

import com.trabajo.Grupo02OO22022.entity.Materia;
import com.trabajo.Grupo02OO22022.repository.MateriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Qualifier("materiaService")
@Service
public class MateriaServiceImplements implements IMateriaService {

    @Autowired
    private MateriaRepository MateriaRepository;

    @Override
    public List<Materia> listaMaterias() {

        return (List<Materia>) MateriaRepository.findAll();
    }

    @Override
    public void guardar(Materia materia) {
        MateriaRepository.save(materia);
    }

    @Override
    public Materia buscarPorID(long id) {
        return MateriaRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(long id) {
        MateriaRepository.deleteById(id);
    }

}
