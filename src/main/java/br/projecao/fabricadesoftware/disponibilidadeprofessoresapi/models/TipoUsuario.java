package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.models;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.dominio.NivelAcesso;

@Entity
@Table(name="TIPO_USUARIO")
public class TipoUsuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(length = 20, unique = true)
	@NonNull
	private String descricao;
	@Enumerated(EnumType.STRING)
	@Column(name = "nivel_acesso")
	@NonNull
	private NivelAcesso nivelAcesso;
	
	@OneToMany(mappedBy = "tipoUsuario")
	private List<Usuario> usuarios;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public NivelAcesso getNivelAcesso() {
		return nivelAcesso;
	}
	public void setNivelAcesso(NivelAcesso nivelAcesso) {
		this.nivelAcesso = nivelAcesso;
	}
	
}
