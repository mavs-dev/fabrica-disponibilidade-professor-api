package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.dominio;

public enum Turno {
	MATUTINO(1), VESPERTINO(2), NOTURNO(3);
	
	private int codigo;
	private Turno(int codigo) {
		this.codigo=codigo;
	}
	
	public int getCodigo() {
		return this.codigo;
	}
}
