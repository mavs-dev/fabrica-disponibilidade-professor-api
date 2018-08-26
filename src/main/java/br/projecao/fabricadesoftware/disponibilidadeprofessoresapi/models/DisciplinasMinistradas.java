package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.models;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;


public class DisciplinasMinistradas {
	
	private String _id;
	private String _idProfessor;
	private Integer periodo;
	private Integer ano;
	private LocalDate dataCadastro;
	private Integer cargaHorariaSemanal;
	private List<Map<UnidadeAcademica, Integer>> cargaHorariaPorUnidade;
	private List<DisciplinaMinistrada> disciplinasMinistradasPorUnidadeAcademica;
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String get_idProfessor() {
		return _idProfessor;
	}
	public void set_idProfessor(String _idProfessor) {
		this._idProfessor = _idProfessor;
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
