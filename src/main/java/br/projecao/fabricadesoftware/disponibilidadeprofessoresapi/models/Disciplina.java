package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;

import org.springframework.data.annotation.Id;

public class Disciplina {
	
	@Id
	@SequenceGenerator( name = "dp_seq_disciplina", sequenceName = "dp_seq_disciplina")
	@GeneratedValue( strategy = GenerationType.SEQUENCE)
	private Long id;
	private String nome;
	private String descricao;
	private String campoDeAtuacao;
	
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getCampoDeAtuacao() {
		return campoDeAtuacao;
	}
	public void setCampoDeAtuacao(String campoDeAtuacao) {
		this.campoDeAtuacao = campoDeAtuacao;
	}
}
