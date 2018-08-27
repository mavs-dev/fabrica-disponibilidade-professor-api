package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.models;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;


public class DisciplinasMinistradas {
	
	private Long id;
	private Integer periodo;
	private Integer ano;
	private LocalDate dataCadastro;
	private Integer cargaHorariaSemanal;
	private List<Map<UnidadeAcademica, Integer>> cargaHorariaPorUnidade;
	private List<DisciplinaMinistrada> disciplinasMinistradasPorUnidadeAcademica;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getPeriodo() {
		return periodo;
	}
	public void setPeriodo(Integer periodo) {
		this.periodo = periodo;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	public LocalDate getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public Integer getCargaHorariaSemanal() {
		return cargaHorariaSemanal;
	}
	public void setCargaHorariaSemanal(Integer cargaHorariaSemanal) {
		this.cargaHorariaSemanal = cargaHorariaSemanal;
	}
	public List<Map<UnidadeAcademica, Integer>> getCargaHorariaPorUnidade() {
		return cargaHorariaPorUnidade;
	}
	public void setCargaHorariaPorUnidade(List<Map<UnidadeAcademica, Integer>> cargaHorariaPorUnidade) {
		this.cargaHorariaPorUnidade = cargaHorariaPorUnidade;
	}
	public List<DisciplinaMinistrada> getDisciplinasMinistradasPorUnidadeAcademica() {
		return disciplinasMinistradasPorUnidadeAcademica;
	}
	public void setDisciplinasMinistradasPorUnidadeAcademica(
			List<DisciplinaMinistrada> disciplinasMinistradasPorUnidadeAcademica) {
		this.disciplinasMinistradasPorUnidadeAcademica = disciplinasMinistradasPorUnidadeAcademica;
	}
	
}
