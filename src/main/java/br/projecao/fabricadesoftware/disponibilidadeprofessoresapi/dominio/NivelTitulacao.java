package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.dominio;

import java.util.ArrayList;
import java.util.List;

public enum NivelTitulacao {

	GRADUACAO(1), POS_GRADUACAO(2), MESTRADO(3), DOUTORADO(4);
	private int codigo;
	private NivelTitulacao(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return this.codigo;
	}
	
	public static List<NivelTitulacao> getLista() {
		List<NivelTitulacao> lista = new ArrayList<>();
		lista.add(GRADUACAO);
		lista.add(POS_GRADUACAO);
		lista.add(MESTRADO);
		lista.add(DOUTORADO);
		return lista;
	}
}
