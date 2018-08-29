package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "DISCIPLINA")
public class Disciplina {
	
	@Id
	@SequenceGenerator( name = "dp_seq_disciplina", sequenceName = "dp_seq_disciplina")
	@GeneratedValue( strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(length = 30, nullable = false, unique = true)
	private String descricao;
	
	@Column(length = 3, nullable = false)
	private Integer cargaHoraria;
	
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "area_de_conhecimento")
	private AreaDeConhecimento areaDeConhecimento;
	
	@JsonBackReference
	@OneToMany(mappedBy = "disciplinaMin")
	private List<DisciplinaMinistrada> disciplinasMinistradas;
	
	@JsonBackReference
	@OneToMany(mappedBy = "disciplina")
	private List<DisciplinaDeInteresse> disciplinasDeInteresse;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	public AreaDeConhecimento getAreaDeConhecimento() {
		return areaDeConhecimento;
	}
	public void setAreaDeConhecimento(AreaDeConhecimento areaDeConhecimento) {
		this.areaDeConhecimento = areaDeConhecimento;
	}
	public List<DisciplinaMinistrada> getDisciplinasMinistradas() {
		return disciplinasMinistradas;
	}
	public void setDisciplinasMinistradas(List<DisciplinaMinistrada> disciplinasMinistradas) {
		this.disciplinasMinistradas = disciplinasMinistradas;
	}
	public List<DisciplinaDeInteresse> getDisciplinasDeInteresse() {
		return disciplinasDeInteresse;
	}
	public void setDisciplinasDeInteresse(List<DisciplinaDeInteresse> disciplinasDeInteresse) {
		this.disciplinasDeInteresse = disciplinasDeInteresse;
	}
	
}
