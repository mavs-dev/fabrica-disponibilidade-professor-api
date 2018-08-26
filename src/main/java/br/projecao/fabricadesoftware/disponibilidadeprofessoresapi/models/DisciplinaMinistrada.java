package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.models;

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.dominio.Turno;

public class DisciplinaMinistrada {
	private Turno turno;
	private UnidadeAcademica unidadeAcademica;
	
	public DisciplinaMinistrada() {
	}

	public DisciplinaMinistrada(Turno turno, UnidadeAcademica unidadeAcademica) {
		this.turno = turno;
		this.unidadeAcademica = unidadeAcademica;
	}
	
	public Turno getTurno() {
		return turno;
	}
	public void setTurno(Turno turno) {
		this.turno = turno;
	}
	public UnidadeAcademica getUnidadeAcademica() {
		return unidadeAcademica;
	}
	public void setUnidadeAcademica(UnidadeAcademica unidadeAcademica) {
		this.unidadeAcademica = unidadeAcademica;
	}
	
}
