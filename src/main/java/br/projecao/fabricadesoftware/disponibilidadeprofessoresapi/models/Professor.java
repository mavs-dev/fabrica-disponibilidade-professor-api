package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name= "DADOS_PROFISSIONAIS")
public class Professor extends Usuario {

	public Professor() {
		super();
	}

	@Column(length = 75, nullable=false)
	private String graduacao;
	
	private LocalDate dataConclusao;
	
	private Boolean maiorTitulacaoObtida;
	@Column(length = 75, nullable=false)
	private String principalAtuacaoProfissional;
	
	private Integer tempoExpProfissional;
	private Integer tempoExpEmMagisterioSuperior;
	private Integer tempoExpDocenciaNaEdBasica;

	@OneToOne
	@JoinColumn(name = "curriculo_lattes")
	private CurriculoLattes curriculoLattes;
	
	
	@OneToMany(mappedBy = "professor", fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"disciplinasDeInteresse"})
	private List<DisciplinaDeInteresse> disciplinasDeInteresse;
	
	@OneToMany(mappedBy = "professor")
	@JsonIgnoreProperties(value= "professor")
	private List<Titulacao> titulacoes;

	public String getGraduacao() {
		return graduacao;
	}

	public void setGraduacao(String graduacao) {
		this.graduacao = graduacao;
	}

	public LocalDate getDataConclusao() {
		return dataConclusao;
	}

	public void setDataConclusao(LocalDate dataConclusao) {
		this.dataConclusao = dataConclusao;
	}

	public Boolean getMaiorTitulacaoObtida() {
		return maiorTitulacaoObtida;
	}

	public void setMaiorTitulacaoObtida(Boolean maiorTitulacaoObtida) {
		this.maiorTitulacaoObtida = maiorTitulacaoObtida;
	}

	public String getPrincipalAtuacaoProfissional() {
		return principalAtuacaoProfissional;
	}

	public void setPrincipalAtuacaoProfissional(String principalAtuacaoProfissional) {
		this.principalAtuacaoProfissional = principalAtuacaoProfissional;
	}

	public Integer getTempoExpProfissional() {
		return tempoExpProfissional;
	}

	public void setTempoExpProfissional(Integer tempoExpProfissional) {
		this.tempoExpProfissional = tempoExpProfissional;
	}

	public Integer getTempoExpEmMagisterioSuperior() {
		return tempoExpEmMagisterioSuperior;
	}

	public void setTempoExpEmMagisterioSuperior(Integer tempoExpEmMagisterioSuperior) {
		this.tempoExpEmMagisterioSuperior = tempoExpEmMagisterioSuperior;
	}

	public Integer getTempoExpDocenciaNaEdBasica() {
		return tempoExpDocenciaNaEdBasica;
	}

	public void setTempoExpDocenciaNaEdBasica(Integer tempoExpDocenciaNaEdBasica) {
		this.tempoExpDocenciaNaEdBasica = tempoExpDocenciaNaEdBasica;
	}

	public CurriculoLattes getCurriculoLattes() {
		return curriculoLattes;
	}

	public void setCurriculoLattes(CurriculoLattes curriculoLattes) {
		this.curriculoLattes = curriculoLattes;
	}

	public List<DisciplinaDeInteresse> getDisciplinasDeInteresse() {
		return disciplinasDeInteresse;
	}

	public void setDisciplinasDeInteresse(List<DisciplinaDeInteresse> disciplinasDeInteresse) {
		this.disciplinasDeInteresse = disciplinasDeInteresse;
	}

	public List<Titulacao> getTitulacoes() {
		return titulacoes;
	}

	public void setTitulacoes(List<Titulacao> titulacoes) {
		this.titulacoes = titulacoes;
	}
}
