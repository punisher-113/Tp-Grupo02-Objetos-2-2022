package com.trabajo.Grupo02OO22022.service;

import java.util.List;

import com.trabajo.Grupo02OO22022.entity.Aula;
import com.trabajo.Grupo02OO22022.entity.Laboratorio;
import com.trabajo.Grupo02OO22022.entity.Tradicional;
import com.trabajo.Grupo02OO22022.repository.AulaRepository;
import com.trabajo.Grupo02OO22022.repository.LaboratorioRepository;
import com.trabajo.Grupo02OO22022.repository.TradicionalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Qualifier("aulaService")
@Service
public class AulaServiceImplements implements IAulaService {

    @Autowired
    private AulaRepository aulaRepository;

    @Autowired
    private TradicionalRepository tradicionalRepository;

    @Autowired
    private LaboratorioRepository laboratorioRepository;

    @Override
    public List<Aula> listaAulas() {

        return (List<Aula>) aulaRepository.findAll();
    }

    @Override
    public void guardar(Aula user) {
        aulaRepository.save(user);
    }

    @Override
    public Tradicional buscarPorID(long id) {
        List<Tradicional> tradicional = tradicionalRepository.findAll();
        Tradicional tradicional1 = null;
        for (Tradicional tradicional2 : tradicional) {
            if (tradicional2.getId() == id) {
                tradicional1 = tradicional2;
            }
        }
        return tradicional1;
    }

    @Override
    public Laboratorio buscarPorIDLab(long id) {
        List<Laboratorio> laboratorio = laboratorioRepository.findAll();
        Laboratorio laboratorio1 = null;
        for (Laboratorio laboratorio2 : laboratorio) {
            if (laboratorio2.getId() == id) {
                laboratorio1 = laboratorio2;
            }
        }
        return laboratorio1;
    }
}
