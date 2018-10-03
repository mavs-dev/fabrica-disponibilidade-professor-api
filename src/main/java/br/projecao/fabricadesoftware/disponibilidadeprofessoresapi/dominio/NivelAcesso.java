package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.dominio;

public enum NivelAcesso {
	ADMINISTRADOR(1, "ROLE_ADMIN"),
	DIRETOR(2, "ROLE_DIRETOR"),
	COORDENADOR(3, "ROLE_COORDENADOR"),
	PROFESSOR(4, "ROLE_PROFESSOR");
	
	private int codigo;
	private String role;
	
	private NivelAcesso(int codigo, String role) {
		this.codigo=codigo;
		this.role=role;
	}
}
