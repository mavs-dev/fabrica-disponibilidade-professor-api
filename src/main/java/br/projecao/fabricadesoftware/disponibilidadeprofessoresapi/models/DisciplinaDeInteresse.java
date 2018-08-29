package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "DISCIPLINA_DE_INTERESSE")
public class DisciplinaDeInteresse {

	@Id
	@SequenceGenerator(name = "dp_seq_disc_inter", sequenceName="dp_seq_disc_inter")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(length = 4)
	private Integer ano;
	
	@Column(length = 1)
	private Integer semestre;
	
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "disciplina")
	private Disciplina disciplina;
	
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "unidade_academica")
	private UnidadeAcademica unidadeAcademica;
	
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "professor")
	private Professor professor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public UnidadeAcademica getUnidadeAcademica() {
		return unidadeAcademica;
	}

	public void setUnidadeAcademica(UnidadeAcademica unidadeAcademica) {
		this.unidadeAcademica = unidadeAcademica;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
}
