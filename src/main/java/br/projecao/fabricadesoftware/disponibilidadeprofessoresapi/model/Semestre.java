package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.model;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="semestre")
@SequenceGenerator(name="dp_seq_semestre", sequenceName="dp_seq_semestre")
public class Semestre {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="dp_seq_semestre")
	private Long id;
	@Column(length=1, scale=2, nullable=false)
	private Integer semestreReferencia;
	@Column(nullable=false)
	private Integer anoReferencia;
	@OneToMany(mappedBy="semestre")
	@JsonIgnoreProperties({"interesses"})
	private Set<Interesse> interesses;
	@OneToMany(mappedBy="semestre")
	@JsonIgnoreProperties({"disponibilidades"})
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
	public Integer getSemestreReferencia() {
		return semestreReferencia;
	}
	public void setSemestreReferencia(Integer semestreReferencia) {
		this.semestreReferencia = semestreReferencia;
	}
	public Integer getAnoReferencia() {
		return anoReferencia;
	}
	public void setAnoReferencia(Integer anoReferencia) {
		this.anoReferencia = anoReferencia;
	}
	public Set<Interesse> getInteresses() {
		return interesses;
	}
	public void setInteresses(Set<Interesse> interesses) {
		this.interesses = interesses;
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
