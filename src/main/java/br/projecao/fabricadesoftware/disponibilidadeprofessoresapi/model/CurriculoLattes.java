package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="curriculo_lattes")
@SequenceGenerator(name="dp_seq_lattes", sequenceName="dp_seq_lattes")
@JsonIgnoreProperties(value= {"dadosProfissionais"}, allowGetters=false, allowSetters=true)
public class CurriculoLattes {

	@Id
	@Column(unique=true)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="dp_seq_lattes")
	private Long id;
	@Column(nullable=false)
	private LocalDate dataAtualizacao;
	@Column(length=255, nullable=false)
	private String url;
	@Column(length=1000, nullable=false)
	private String publicacoes;

	@OneToOne(cascade=CascadeType.DETACH)
	@JoinColumn(name = "id_dados_profissionais")
	private DadosProfissionais dadosProfissionais;
	
	private LocalDateTime dataHoraCadastro;
	private LocalDateTime dataHoraAlteracao;
	private LocalDateTime dataHoraExclusao;
	
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

}
