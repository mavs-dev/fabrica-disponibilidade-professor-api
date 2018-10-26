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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="unidade_academica")
@SequenceGenerator(name="dp_seq_uni_acad", sequenceName="dp_seq_uni_acad")
@JsonIgnoreProperties(value={"disponibilidades"}, allowGetters=false, allowSetters=false)
public class UnidadeAcademica {

	@Id
	@Column(unique=true)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="dp_seq_uni_acad")
	private Long id;
	@Column(length=50, nullable=false)
	private String nome;
	@Column(length=5, nullable=true)
	private String sigla;
	
	@ManyToMany(mappedBy="unidadesAcademicas")
	private Set<Disponibilidade> disponibilidades;

	private LocalDateTime dataHoraCadastro;
	private LocalDateTime dataHoraAlteracao;
	private LocalDateTime dataHoraExclusao;
	
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
	public Set<Disponibilidade> getDisponibilidades() {
		return disponibilidades;
	}
	public void setDisponibilidades(Set<Disponibilidade> disponibilidades) {
		this.disponibilidades = disponibilidades;
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
