package com.trabajo.Grupo02OO22022.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "laboratorio")
@PrimaryKeyJoinColumn(referencedColumnName = "id")
@Getter
@Setter
@RequiredArgsConstructor
public class Laboratorio extends Aula {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotEmpty
	@Column(name = "cantPC", nullable = false)
	private int cantPC;

	@NotEmpty
	@Column(name = "cantSillas", nullable = false)
	private int cantSillas;

}
