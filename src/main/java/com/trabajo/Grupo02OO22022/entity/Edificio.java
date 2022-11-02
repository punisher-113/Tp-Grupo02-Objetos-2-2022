package com.trabajo.Grupo02OO22022.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "edificio")
@Getter
@Setter
@RequiredArgsConstructor
public class Edificio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotEmpty
	@Column(name = "edificio", nullable = false)
	private String edificio;

	// El set si que no se como codearlo para la bd
	@NotEmpty
	@Column(name = "aulas", nullable = false)
	@OneToMany(mappedBy = "edificio")
	private Set<Aula> aulas;

}
