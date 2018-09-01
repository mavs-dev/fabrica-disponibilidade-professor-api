package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "TITULACAO")
public class Titulacao {

	@Id
	@SequenceGenerator(name = "dp_seq_titulacao", sequenceName = "dp_seq_titulacao")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(length = 45)
	private String descricao;

	private Boolean titulacaoEmAndamento;
	private Boolean maiorTitulacaoObtida;
	private LocalDate dataTermino;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "professor")
	@JsonIgnoreProperties(value= "titulacoes", allowSetters=true)
	private Professor professor;

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

	public Boolean getTitulacaoEmAndamento() {
		return titulacaoEmAndamento;
	}

	public void setTitulacaoEmAndamento(Boolean titulacaoEmAndamento) {
		this.titulacaoEmAndamento = titulacaoEmAndamento;
	}

	public Boolean getMaiorTitulacaoObtida() {
		return maiorTitulacaoObtida;
	}

	public void setMaiorTitulacaoObtida(Boolean maiorTitulacaoObtida) {
		this.maiorTitulacaoObtida = maiorTitulacaoObtida;
	}

	public LocalDate getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(LocalDate dataTermino) {
		this.dataTermino = dataTermino;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
}
