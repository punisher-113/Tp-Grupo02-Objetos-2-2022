package com.trabajo.Grupo02OO22022.service;

import java.util.List;

import com.trabajo.Grupo02OO22022.entity.Docente;
import com.trabajo.Grupo02OO22022.repository.DocenteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Qualifier("docenteService")
@Service
public class DocenteServiceImplements implements IDocenteService {

    @Autowired
    private DocenteRepository DocenteRepository;

    @Override
    public List<Docente> listarTodos() {
        return (List<Docente>) DocenteRepository.findAll();
    }

    @Override
    public void guardar(Docente Docente) {
        DocenteRepository.save(Docente);
    }

    @Override
    public Docente buscarPorID(long id) {
        return DocenteRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(long id) {
        DocenteRepository.deleteById(id);
    }

}
