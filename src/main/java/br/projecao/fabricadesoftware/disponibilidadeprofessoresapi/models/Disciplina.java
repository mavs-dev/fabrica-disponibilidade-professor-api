package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.springframework.data.annotation.Id;

public class Disciplina {
	
	@Id
	@SequenceGenerator( name = "dp_seq_disciplina", sequenceName = "dp_seq_disciplina")
	@GeneratedValue( strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(length = 30, nullable = false, unique = true)
	private String descricao;
	
	@Column(length = 3, nullable = false)
	private Integer cargaHoraria;
	
	@ManyToOne
	@JoinColumn(name = "area_de_conhecimento")
	private AreaDeConhecimento areaDeConhecimento;

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
}
