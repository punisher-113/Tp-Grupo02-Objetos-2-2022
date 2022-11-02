package com.trabajo.Grupo02OO22022.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "materia")
@Getter
@Setter
@RequiredArgsConstructor

public class Materia implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    @Column(name = "codMateria", nullable = false, length = 30)
    private int codMateria;

    @NotEmpty
    @Column(name = "materia", nullable = false, length = 45)
    private String materia;

    // Faltan las relaciones entre carrera/docente con materia
    @NotEmpty
    @ManyToOne
    @JoinColumn(name = "carrera_id")
    private Carrera carrera;

    @ManyToMany
    @JoinTable(name = "materiaxdocente", joinColumns = @JoinColumn(name = "materiaId"), inverseJoinColumns = @JoinColumn(name = "docenteId"))
    private Set<Docente> docente;

}
