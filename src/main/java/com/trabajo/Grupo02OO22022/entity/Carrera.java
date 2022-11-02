package com.trabajo.Grupo02OO22022.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "carrera")
@Getter
@Setter
@RequiredArgsConstructor

public class Carrera implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotEmpty
	@ManyToOne
	@JoinColumn(name = "departamento_id")
	private Departamento departamento;

	@NotEmpty
	@Column(name = "carrera", nullable = false, length = 60)
	private String carrera;

}
