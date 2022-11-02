package com.trabajo.Grupo02OO22022.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "curso")
@Getter
@Setter
@RequiredArgsConstructor
public class Curso extends NotaPedido {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotEmpty
	@Column(name = "codCurso", nullable = false, length = 60)
	private String carrera;

	@NotEmpty
	@Column(name = "proyector", nullable = false, length = 60)
	private boolean proyector;

}
