package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CURRICULO_LATTES")
public class CurriculoLattes {
	
	@Id
	@SequenceGenerator(name = "dp_seq_curriculo_lattes", sequenceName= "dp_seq_curriculo_lattes")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(length = 150)
	private String url;
	
	private LocalDate dataUltimaAtt;
	private String ultimasPublicacoes;
	
	@OneToOne(mappedBy = "curriculoLattes")
	private Professor professor;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public LocalDate getDataUltimaAtt() {
		return dataUltimaAtt;
	}
	public void setDataUltimaAtt(LocalDate dataUltimaAtt) {
		this.dataUltimaAtt = dataUltimaAtt;
	}
	public String getUltimasPublicacoes() {
		return ultimasPublicacoes;
	}
	public void setUltimasPublicacoes(String ultimasPublicacoes) {
		this.ultimasPublicacoes = ultimasPublicacoes;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
}
