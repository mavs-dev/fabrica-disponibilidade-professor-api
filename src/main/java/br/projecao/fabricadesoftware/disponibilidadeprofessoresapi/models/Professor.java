package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.models;

import java.time.LocalDate;


public class Professor extends Usuario {

	public Professor() {
		super();
	}

	// PROFESSIONAL DATA
	private String graduacao;
	private LocalDate dataConclusao;
	private String maiorTitulacaoObtida;
	private Boolean titulacaoEmAndamento;
	private String nomeTitulacaoEmAndamento;
	private LocalDate estimativaTerminoTitulacaoEmAndamento;
	private String principalAtuacaoProfissional;
	private Integer tempoExpProfissional;
	private Integer tempoExpEmMagisterioSuperior;
	private Integer tempoExpDocenciaNaEdBasica;
	private LocalDate ultimaAttLattes;
	private String urlLattes;
	private String ultimasPublicacoesLattes;

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

	public String getMaiorTitulacaoObtida() {
		return maiorTitulacaoObtida;
	}

	public void setMaiorTitulacaoObtida(String maiorTitulacaoObtida) {
		this.maiorTitulacaoObtida = maiorTitulacaoObtida;
	}

	public Boolean getTitulacaoEmAndamento() {
		return titulacaoEmAndamento;
	}

	public void setTitulacaoEmAndamento(Boolean titulacaoEmAndamento) {
		this.titulacaoEmAndamento = titulacaoEmAndamento;
	}

	public String getNomeTitulacaoEmAndamento() {
		return nomeTitulacaoEmAndamento;
	}

	public void setNomeTitulacaoEmAndamento(String nomeTitulacaoEmAndamento) {
		this.nomeTitulacaoEmAndamento = nomeTitulacaoEmAndamento;
	}

	public LocalDate getEstimativaTerminoTitulacaoEmAndamento() {
		return estimativaTerminoTitulacaoEmAndamento;
	}

	public void setEstimativaTerminoTitulacaoEmAndamento(LocalDate estimativaTerminoTitulacaoEmAndamento) {
		this.estimativaTerminoTitulacaoEmAndamento = estimativaTerminoTitulacaoEmAndamento;
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

	public LocalDate getUltimaAttLattes() {
		return ultimaAttLattes;
	}

	public void setUltimaAttLattes(LocalDate ultimaAttLattes) {
		this.ultimaAttLattes = ultimaAttLattes;
	}

	public String getUrlLattes() {
		return urlLattes;
	}

	public void setUrlLattes(String urlLattes) {
		this.urlLattes = urlLattes;
	}

	public String getUltimasPublicacoesLattes() {
		return ultimasPublicacoesLattes;
	}

	public void setUltimasPublicacoesLattes(String ultimasPublicacoesLattes) {
		this.ultimasPublicacoesLattes = ultimasPublicacoesLattes;
	}

}
