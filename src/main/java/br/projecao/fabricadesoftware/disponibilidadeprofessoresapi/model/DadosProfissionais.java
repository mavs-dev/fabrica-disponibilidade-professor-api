package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.dominio.NivelTitulacao;

@Entity
@Table(name="dados_profissionais")
@SequenceGenerator(name="dp_seq_dados_prof", sequenceName="dp_seq_dados_prof")
public class DadosProfissionais {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="dp_seq_dados_prof")
	private Long id;
	@Column(length=75,nullable=false)
	private String graduacao;
	@Column(nullable=false)
	private LocalDate dataConclusao;
	@Column(nullable=false)
	@Enumerated(EnumType.ORDINAL)
	private NivelTitulacao maiorTitulacaoObtida;
	@Column(nullable=false)
	private boolean titulacaoEmAndamento;
	@Column(length=75)
	private String descricaoTitulacaoEmAndamento;
	@Column(length=75, nullable=false)
	private String principalAtuacaoProfissional;
	@Column(nullable=false)
	private Integer tempoExpProfissional;
	@Column(nullable=false)
	private Integer tempoExpMagisterioSuperior;
	@Column(nullable=false)
	private Integer tempoExpDocenciaEdBasica;
	
	@OneToOne(mappedBy="dadosProfissionais", cascade=CascadeType.DETACH)
	@JsonIgnoreProperties(value={"dadosProfissionais"},allowGetters=false)
	private CurriculoLattes curriculoLattes;
	
	@OneToOne
	@JoinColumn(name = "id_professor")
	@JsonIgnoreProperties(value= {"dadosProfissionais"},allowGetters=false)
	private Usuario professor;
	
	private LocalDateTime dataHoraCadastro;
	private LocalDateTime dataHoraAlteracao;
	private LocalDateTime dataHoraExclusao;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public NivelTitulacao getMaiorTitulacaoObtida() {
		return maiorTitulacaoObtida;
	}
	public void setMaiorTitulacaoObtida(NivelTitulacao maiorTitulacaoObtida) {
		this.maiorTitulacaoObtida = maiorTitulacaoObtida;
	}
	public boolean isTitulacaoEmAndamento() {
		return titulacaoEmAndamento;
	}
	public void setTitulacaoEmAndamento(boolean titulacaoEmAndamento) {
		this.titulacaoEmAndamento = titulacaoEmAndamento;
	}
	public String getDescricaoTitulacaoEmAndamento() {
		return descricaoTitulacaoEmAndamento;
	}
	public void setDescricaoTitulacaoEmAndamento(String descricaoTitulacaoEmAndamento) {
		this.descricaoTitulacaoEmAndamento = descricaoTitulacaoEmAndamento;
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
	public Integer getTempoExpMagisterioSuperior() {
		return tempoExpMagisterioSuperior;
	}
	public void setTempoExpMagisterioSuperior(Integer tempoExpMagisterioSuperior) {
		this.tempoExpMagisterioSuperior = tempoExpMagisterioSuperior;
	}
	public Integer getTempoExpDocenciaEdBasica() {
		return tempoExpDocenciaEdBasica;
	}
	public void setTempoExpDocenciaEdBasica(Integer tempoExpDocenciaEdBasica) {
		this.tempoExpDocenciaEdBasica = tempoExpDocenciaEdBasica;
	}
	public CurriculoLattes getCurriculoLattes() {
		return curriculoLattes;
	}
	public void setCurriculoLattes(CurriculoLattes curriculoLattes) {
		this.curriculoLattes = curriculoLattes;
	}
	public Usuario getProfessor() {
		return professor;
	}
	public void setProfessor(Usuario professor) {
		this.professor = professor;
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
