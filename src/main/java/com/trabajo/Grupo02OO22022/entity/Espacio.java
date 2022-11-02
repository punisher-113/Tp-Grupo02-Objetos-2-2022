package com.trabajo.Grupo02OO22022.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "espacio")
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class Espacio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotEmpty
	@NonNull
	@Column(name = "fecha", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fecha;

	@NotEmpty
	@NonNull
	@Column(name = "turno", nullable = false)
	private char turno;

	@NotEmpty
	@NonNull
	@Column(name = "libre", nullable = false)
	private boolean libre;

	@ManyToOne
	@NonNull
	@JoinColumn(name = "aula_id")
	private Aula aula;

}
