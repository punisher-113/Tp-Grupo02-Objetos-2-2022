package com.trabajo.Grupo02OO22022.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trabajo.Grupo02OO22022.entity.NotaPedido;

@Repository
public interface NotaPedidoRepository extends CrudRepository<NotaPedido, Long> {

    List<NotaPedido> findAll();

}
