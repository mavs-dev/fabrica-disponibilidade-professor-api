package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.dominio;

public enum DiaDaSemana {
	
	SEGUNDA(1,"SEG"),
	TERCA(2, "TER"),
	QUARTA(3, "QUA"),
	QUINTA(4, "QUI"),
	SEXTA(5, "SEX"),
	SABADO(6, "SAB");
	
	private int codigo;
	private String sigla;
	private DiaDaSemana(int codigo, String sigla) {
		this.codigo= codigo;
		this.sigla= sigla;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public String getSigla() {
		return sigla;
	}
	
}
