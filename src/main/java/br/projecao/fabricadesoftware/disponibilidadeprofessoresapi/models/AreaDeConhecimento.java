package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

public class AreaDeConhecimento {

	@Id
	@SequenceGenerator(name = "dp_seq_area_conhec",  sequenceName = "dp_seq_area_conhec")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(length = 20, nullable = false)
	private String descricao;
	
	@OneToMany(mappedBy = "areaDeConhecimento")
	private List<Disciplina> disciplinas;
	
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
		
}
