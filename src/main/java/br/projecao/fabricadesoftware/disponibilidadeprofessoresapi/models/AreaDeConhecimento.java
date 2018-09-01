package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "AREA_DE_CONHECIMENTO")
public class AreaDeConhecimento {

	@Id
	@SequenceGenerator(name = "dp_seq_area_conhec",  sequenceName = "dp_seq_area_conhec")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(length = 20, nullable = false)
	private String descricao;
	
	@OneToMany(mappedBy = "areaDeConhecimento", fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"disciplinas"})
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
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
		
}
