package com.trabajo.Grupo02OO22022.service;

import java.util.List;

import com.trabajo.Grupo02OO22022.entity.Curso;
import com.trabajo.Grupo02OO22022.entity.Final;
import com.trabajo.Grupo02OO22022.entity.NotaPedido;
import com.trabajo.Grupo02OO22022.repository.CursoRepository;
import com.trabajo.Grupo02OO22022.repository.FinalRepository;
import com.trabajo.Grupo02OO22022.repository.NotaPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Qualifier("notaPedidoService")
@Service
public class NotaPedidoServiceImplements implements INotaPedidoService {

    @Autowired
    private NotaPedidoRepository notaRepository;

    @Autowired
    private FinalRepository finalRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public List<NotaPedido> listarTodos() {
        return (List<NotaPedido>) notaRepository.findAll();
    }

    @Override
    public void guardar(NotaPedido notaPedido) {
        notaRepository.save(notaPedido);
    }

    @Override
    public List<Final> getAll() {
        return finalRepository.findAll();
    }

    @Override
    public List<Curso> getAll1() {
        return cursoRepository.findAll();
    }

    @Override
    public Final insertOrUpdate(Final final1) {

        return finalRepository.save(final1);
    }

    @Override
    public Curso insertOrUpdateCurso(Curso curso) {

        return cursoRepository.save(curso);
    }

    @Override
    public void eliminarCurso(long id) {
        cursoRepository.deleteById(id);

    }

    @Override
    public void eliminarFinal(long id) {
        finalRepository.deleteById(id);

    }
    @Override
    public Final buscarPorID(long id) {
        List<Final> final1 = finalRepository.findAll();
        Final final2 = null;
        for (Final final3 : final1) {
            if (final3.getId() == id) {
                final2 = final3;
            }
        }
        return final2;
    }

    @Override
    public Curso buscarPorIDCurso(long id) {
        List<Curso> curso = cursoRepository.findAll();
        Curso curso1 = new Curso();
        for (Curso curso2 : curso) {
            if (curso2.getId() == id) {
                curso1 = curso2;
            }
        }
        return curso1;
    }

}
