package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.model;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="unidade_academica")
public class UnidadeAcademica {

	@Id
	@SequenceGenerator(name="dp_seq_uni_acad", sequenceName="dp_seq_uni_acad")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	@Column(length=50, nullable=false)
	private String nome;
	@Column(length=5, nullable=true)
	private String sigla;
	
	private LocalDateTime dataHoraCadastro;
	private LocalDateTime dataHoraAlteracao;
	private LocalDateTime dataHoraExclusao;

	@ManyToMany(mappedBy="unidadesAcademicas")
	private Set<Disponibilidade> disponibilidades;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public LocalDateTime getDataHoraCadastro() {
		return dataHoraCadastro;
	}

	public void setDataHoraCadastro(LocalDateTime dataHoraCadastro) {
		this.dataHoraCadastro = dataHoraCadastro;
	}

	public LocalDateTime getDataHoraAlteracao() {
		return dataHoraAlteracao;
	}

	public void setDataHoraAlteracao(LocalDateTime dataHoraAlteracao) {
		this.dataHoraAlteracao = dataHoraAlteracao;
	}

	public LocalDateTime getDataHoraExclusao() {
		return dataHoraExclusao;
	}

	public void setDataHoraExclusao(LocalDateTime dataHoraExclusao) {
		this.dataHoraExclusao = dataHoraExclusao;
	}

}
