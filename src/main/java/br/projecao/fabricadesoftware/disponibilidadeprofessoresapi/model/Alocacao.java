package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.dominio.DiaDaSemana;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.dominio.Turno;

@Entity
@Table(name="alocacao")
@SequenceGenerator(name="dp_seq_alocacao", sequenceName="dp_seq_alocacao")
public class Alocacao {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="dp_seq_alocacao")
	private Long id;
	@ManyToOne
	@JoinColumn(name="id_responsavel_alocacao")
	private Usuario responsavelAlocacao;
	@ManyToOne
	@JoinColumn(name="id_unidade_academica")
	private UnidadeAcademica unidadeAcademica;
	@Enumerated(EnumType.ORDINAL)
	private Turno turno;
	@Enumerated(EnumType.ORDINAL)
	private DiaDaSemana diaDaSemana;
	@ManyToOne
	@JoinColumn(name="id_professor")
	private Usuario professor;
	@ManyToOne
	@JoinColumn(name="id_disciplina")
	private Disciplina disciplina;
	@ManyToOne
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
	public Usuario getResponsavelAlocacao() {
		return responsavelAlocacao;
	}
	public void setResponsavelAlocacao(Usuario responsavelAlocacao) {
		this.responsavelAlocacao = responsavelAlocacao;
	}
	public UnidadeAcademica getUnidadeAcademica() {
		return unidadeAcademica;
	}
	public void setUnidadeAcademica(UnidadeAcademica unidadeAcademica) {
		this.unidadeAcademica = unidadeAcademica;
	}
	public Turno getTurno() {
		return turno;
	}
	public void setTurno(Turno turno) {
		this.turno = turno;
	}
	public DiaDaSemana getDiaDaSemana() {
		return diaDaSemana;
	}
	public void setDiaDaSemana(DiaDaSemana diaDaSemana) {
		this.diaDaSemana = diaDaSemana;
	}
	public Usuario getProfessor() {
		return professor;
	}
	public void setProfessor(Usuario professor) {
		this.professor = professor;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
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
