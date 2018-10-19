package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="curriculo_lattes")
public class CurriculoLattes {

	@Id
	@SequenceGenerator(name="dp_seq_lattes", sequenceName="dp_seq_lattes")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	@Column(nullable=false)
	private LocalDate dataAtualizacao;
	@Column(length=255, nullable=false)
	private String url;
	@Column(length=1000, nullable=false)
	private String publicacoes;
	
	@OneToOne(mappedBy = "curriculoLattes")
	@JsonIgnoreProperties({"dadosProfissionais"})
	private DadosProfissionais dadosProfissionais;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getDataAtualizacao() {
		return dataAtualizacao;
	}
	public void setDataAtualizacao(LocalDate dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPublicacoes() {
		return publicacoes;
	}
	public void setPublicacoes(String publicacoes) {
		this.publicacoes = publicacoes;
	}
	public DadosProfissionais getDadosProfissionais() {
		return dadosProfissionais;
	}
	public void setDadosProfissionais(DadosProfissionais dadosProfissionais) {
		this.dadosProfissionais = dadosProfissionais;
	}
	
}