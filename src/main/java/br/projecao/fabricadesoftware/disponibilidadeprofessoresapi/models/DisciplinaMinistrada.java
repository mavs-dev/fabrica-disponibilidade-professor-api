package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.dominio.Turno;

@Entity
@Table(name = "DISCIPLINA_MINISTRADA")
public class DisciplinaMinistrada {
	
	@Id
	@SequenceGenerator(name = "dp_seq_disc_ministrada", sequenceName = "dp_seq_disc_ministrada")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private Turno turno;
	
	@ManyToOne
	@JoinColumn(name = "unidade_academica")
	private UnidadeAcademica unidadeAcademica;
	
	@Column(length = 4)
	private Integer ano;
	
	@Column(length = 1)
	private Integer semestre;
	
	@ManyToOne
	@JoinColumn(name = "disciplina_min")
	private Disciplina disciplinaMin;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Turno getTurno() {
		return turno;
	}
	public void setTurno(Turno turno) {
		this.turno = turno;
	}
	public UnidadeAcademica getUnidadeAcademica() {
		return unidadeAcademica;
	}
	public void setUnidadeAcademica(UnidadeAcademica unidadeAcademica) {
		this.unidadeAcademica = unidadeAcademica;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	public Integer getSemestre() {
		return semestre;
	}
	public void setSemestre(Integer semestre) {
		this.semestre = semestre;
	}
	public Disciplina getDisciplinaMin() {
		return disciplinaMin;
	}
	public void setDisciplinaMin(Disciplina disciplinaMin) {
		this.disciplinaMin = disciplinaMin;
	}
	
}
