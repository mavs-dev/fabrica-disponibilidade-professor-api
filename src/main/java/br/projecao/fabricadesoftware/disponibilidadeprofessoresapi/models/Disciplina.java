package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.models;

import org.springframework.data.annotation.Id;

public class Disciplina {
	
	@Id
	private String _id;
	private String nome;
	private String descricao;
	private String campoDeAtuacao;
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
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
