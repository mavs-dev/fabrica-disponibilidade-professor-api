 package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="UNIDADE_ACADEMICA")
public class UnidadeAcademica {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	@Column(length = 25)
	private String nome;
	@Column(length = 60)
	private String cidade;
	@Column(length = 150)
	private String endereco;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
}
