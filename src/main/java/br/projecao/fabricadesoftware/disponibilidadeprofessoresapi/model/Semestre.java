package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.model;

import java.time.LocalDate;
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
public class Semestre {
	
	@Id
	@SequenceGenerator(name="dp_seq_semestre", sequenceName="dp_seq_semestre")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	@Column(length=1, scale=2, nullable=false)
	private Integer semestreReferencia;
	@Column(nullable=false)
	private Integer anoReferencia;
	@Column(nullable=false)
	private LocalDate dataCadastro;
	@OneToMany(mappedBy="semestre")
	@JsonIgnoreProperties({"interesses"})
	private Set<Interesse> interesses;
	@OneToMany(mappedBy="semestre")
	@JsonIgnoreProperties({"disponibilidades"})
	private Set<Disponibilidade> disponibilidades;
	
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
	public LocalDate getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
}
