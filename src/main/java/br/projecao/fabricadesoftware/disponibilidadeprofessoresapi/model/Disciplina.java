package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.model;

import java.time.LocalDateTime;
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
@Table(name="disciplina")
public class Disciplina {

	@Id
	@SequenceGenerator(name="dp_seq_disciplina", sequenceName="dp_seq_disciplina")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	@Column(length=75, nullable=false)
	private String descricao;
	
	private LocalDateTime dataHoraCadastro;
	private LocalDateTime dataHoraAlteracao;
	private LocalDateTime dataHoraExclusao;
	
	@OneToMany(mappedBy = "disciplina", fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"interesse"})
	private List<Interesse> interesse;
	
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
	public List<Interesse> getInteresse() {
		return interesse;
	}
	public void setInteresse(List<Interesse> interesse) {
		this.interesse = interesse;
	}
	
}
