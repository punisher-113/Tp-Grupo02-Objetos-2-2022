package com.trabajo.Grupo02OO22022.service;

import java.util.List;

import com.trabajo.Grupo02OO22022.entity.Persona;
import com.trabajo.Grupo02OO22022.repository.PersonaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Qualifier("personaService")
@Service
public class PersonaServiceImplements implements IPersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public List<Persona> listarTodos() {
        return (List<Persona>) personaRepository.findAll();
    }

    @Override
    public Persona buscarPorID(long id) {
        return personaRepository.findById(id).orElse(null);
    }

    @Override
    public void guardar(Persona user) {
        personaRepository.save(user);
    }

    @Override
    public List<Persona> listarDni(Long dni) {

        return personaRepository.findByDni(dni);
    }

    @Override
    public Persona buscarPorDni(long dni) {
        return personaRepository.findByDni(dni);
    }

}
