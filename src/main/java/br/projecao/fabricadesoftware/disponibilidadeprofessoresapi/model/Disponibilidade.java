package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.dominio.DiaDaSemana;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.dominio.Turno;

@Entity
@Table
public class Disponibilidade {

	@Id
	@SequenceGenerator(name="dp_seq_disponibilidade", sequenceName="dp_seq_disponibilidade")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	@Column(nullable=false)
	@ManyToMany
    @JoinTable(name="unidades_da_disponibilidade", joinColumns=
    {@JoinColumn(name="id_disponibilidade")}, inverseJoinColumns=
      {@JoinColumn(name="id_unidades_academicas")})
	private Set<UnidadeAcademica> unidadesAcademicas;
	@Column(nullable=false)
	@Enumerated(EnumType.ORDINAL)
	private Turno turno;
	@Column(nullable=false)
	@Enumerated(EnumType.ORDINAL)
	private DiaDaSemana diaDaSemana;
	@ManyToOne
	@JoinColumn(name = "id_semestre")
	@JsonIgnoreProperties(value = "disponibilidade", allowSetters = true)
	private Semestre semestre;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Set<UnidadeAcademica> getUnidadesAcademicas() {
		return unidadesAcademicas;
	}
	public void setUnidadesAcademicas(Set<UnidadeAcademica> unidadesAcademicas) {
		this.unidadesAcademicas = unidadesAcademicas;
	}
	public Turno getTurno() {
		return turno;
	}
	public void setTurno(Turno turno) {
		this.turno = turno;
	}
	public DiaDaSemana getDiaDaSemana() {
		return diaDaSemana;
	}
	public void setDiaDaSemana(DiaDaSemana diaDaSemana) {
		this.diaDaSemana = diaDaSemana;
	}
	
}
