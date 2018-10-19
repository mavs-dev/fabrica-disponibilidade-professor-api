package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.dominio;

import java.util.ArrayList;
import java.util.List;

public enum Perfil {
	ADMINISTRADOR(0, "ROLE_ADMIN"),
	DIRETOR(1, "ROLE_DIRETOR"),
	COORDENADOR(2, "ROLE_COORDENADOR"),
	PROFESSOR(3, "ROLE_PROFESSOR");
	
	private int codigo;
	private String role;
	
	private Perfil(int codigo, String role) {
		this.codigo=codigo;
		this.role=role;
	}
	
	public int getCodigo() {
		return this.codigo;
	}
	
	public String getRole() {
		return this.role;
	}
	
	public boolean equals(Perfil nivel) {
		return this.codigo == nivel.codigo;
	}
	public boolean equals(String role) {
		return this.role.equals(role);
	}
	
	public Perfil getNivelAcesso(int codigo) {
		switch (codigo) {
		case 1:
			return ADMINISTRADOR;
		case 2:
			return DIRETOR;
		case 3:
			return COORDENADOR;
		case 4:
			return PROFESSOR;
		default:
			return null;
		}
	}
	
	public Perfil getNivelAcesso(String role) {
		switch (role) {
		case "ROLE_ADMIN":
			return ADMINISTRADOR;
		case "ROLE_DIRETOR":
			return DIRETOR;
		case "ROLE_COORDENADOR":
			return COORDENADOR;
		case "ROLE_PROFESSOR":
			return PROFESSOR;
		default:
			return null;
		}
	}
	
	public List<Perfil> getLista(){
		List<Perfil> lista = new ArrayList<>();
		lista.add(ADMINISTRADOR);
		lista.add(DIRETOR);
		lista.add(COORDENADOR);
		lista.add(PROFESSOR);
		return lista;
	}
}
