 package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="UNIDADE_ACADEMICA")
public class UnidadeAcademica {
	
	@Id
	@SequenceGenerator(name = "dp_seq_uni_academica", sequenceName="dp_seq_uni_academica")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(length = 25)
	private String nome;
	
	@Column(length = 60)
	private String cidade;
	
	@Column(length = 150)
	private String endereco;
	
	@OneToMany(mappedBy = "unidadeAcademica")
	private List<DisciplinaMinistrada> disciplinasMinistradas;
	
	@OneToMany(mappedBy = "unidadeAcademica")
	private List<DisciplinaDeInteresse> disciplinasDeInteresse;
	
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
	public List<DisciplinaMinistrada> getDisciplinasMinistradas() {
		return disciplinasMinistradas;
	}
	public void setDisciplinasMinistradas(List<DisciplinaMinistrada> disciplinasMinistradas) {
		this.disciplinasMinistradas = disciplinasMinistradas;
	}
	public List<DisciplinaDeInteresse> getDisciplinasDeInteresse() {
		return disciplinasDeInteresse;
	}
	public void setDisciplinasDeInteresse(List<DisciplinaDeInteresse> disciplinasDeInteresse) {
		this.disciplinasDeInteresse = disciplinasDeInteresse;
	}
}
