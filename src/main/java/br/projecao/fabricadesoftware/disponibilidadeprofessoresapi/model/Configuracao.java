package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="configuracao", uniqueConstraints= {
		@UniqueConstraint(columnNames = {
				"id_periodo_preen",
				"id_periodo_plan",
				"id_semestre_ref"})
})
@SequenceGenerator(name="dp_seq_configuracao", sequenceName="dp_seq_configuracao")
public class Configuracao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="dp_seq_configuracao")
	private Long id;
	@OneToOne(optional=false)
	@JoinColumn(name="id_periodo_preen")
	private PeriodoPreenchimento periodoPreenchimento;
	@OneToOne(optional=false)
	@JoinColumn(name="id_periodo_plan")
	private PeriodoPlanejamento periodoPlanejamento;
	@OneToOne(optional=false)
	@JoinColumn(name="id_semestre_ref")
	private Semestre semestreReferencia;
	
	private LocalDateTime dataHoraCadastro;
	private LocalDateTime dataHoraAlteracao;
	private LocalDateTime dataHoraExclusao;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public PeriodoPreenchimento getPeriodoPreenchimento() {
		return periodoPreenchimento;
	}
	public void setPeriodoPreenchimento(PeriodoPreenchimento periodoPreenchimento) {
		this.periodoPreenchimento = periodoPreenchimento;
	}
	public PeriodoPlanejamento getPeriodoPlanejamento() {
		return periodoPlanejamento;
	}
	public void setPeriodoPlanejamento(PeriodoPlanejamento periodoPlanejamento) {
		this.periodoPlanejamento = periodoPlanejamento;
	}
	public Semestre getSemestreReferencia() {
		return semestreReferencia;
	}
	public void setSemestreReferencia(Semestre semestreReferencia) {
		this.semestreReferencia = semestreReferencia;
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
