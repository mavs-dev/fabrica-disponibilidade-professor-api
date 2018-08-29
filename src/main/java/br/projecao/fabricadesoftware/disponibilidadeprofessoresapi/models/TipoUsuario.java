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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.dominio.NivelAcesso;

@Entity
@Table(name="TIPO_USUARIO")
public class TipoUsuario {
	
	@Id
	@SequenceGenerator(name = "dp_seq_tipo_usuario", sequenceName = "dp_seq_tipo_usuario")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(length = 20, unique = true)
	@NonNull
	private String descricao;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "nivel_acesso")
	private NivelAcesso nivelAcesso;
	
	@JsonBackReference
	@OneToMany(mappedBy = "tipoUsuario")
	private List<Usuario> usuarios;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
