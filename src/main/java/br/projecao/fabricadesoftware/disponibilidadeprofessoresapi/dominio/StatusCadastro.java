package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.dominio;

public enum StatusCadastro {

	ATIVO(1), EXCLUIDO(2);
	
	private int codigo;
	private StatusCadastro(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo(){
		return this.codigo;
	}
}
