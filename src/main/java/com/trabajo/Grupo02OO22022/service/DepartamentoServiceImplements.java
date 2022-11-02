package com.trabajo.Grupo02OO22022.service;

import java.util.List;

import com.trabajo.Grupo02OO22022.entity.Departamento;
import com.trabajo.Grupo02OO22022.repository.DepartamentoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Qualifier("departamentoService")
@Service
public class DepartamentoServiceImplements implements IDepartamentoService {

    @Autowired
    private DepartamentoRepository DepartamentoRepository;

    @Override
    public List<Departamento> listarTodos() {
        return (List<Departamento>) DepartamentoRepository.findAll();
    }

    @Override
    public Departamento buscarPorID(long id) {
        return DepartamentoRepository.findById(id).orElse(null);
    }

    @Override
    public void guardar(Departamento departamento) {
        DepartamentoRepository.save(departamento);
    }

}
