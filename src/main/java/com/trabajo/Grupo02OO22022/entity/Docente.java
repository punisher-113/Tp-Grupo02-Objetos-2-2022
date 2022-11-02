package com.trabajo.Grupo02OO22022.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "docente")
@Getter
@Setter
@RequiredArgsConstructor
public class Docente extends Persona implements Serializable {

	@NotEmpty
	@Column(name = "nroLegajo")
	private int nroLegajo;

}
