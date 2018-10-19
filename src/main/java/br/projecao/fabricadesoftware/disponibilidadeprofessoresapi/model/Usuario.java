package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.dominio.Perfil;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@SequenceGenerator(name="dp_seq_usuario", sequenceName="dp_seq_usuario")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	@Column(length=75, nullable=false)
	private String nome;
	@Column(length=100, nullable=false, unique=true)
	private String email;
	@Column(length=255, nullable=false)
	private String senha;
	
	private LocalDateTime dataHoraCadastro;
	private LocalDateTime dataHoraAlteracao;
	private LocalDateTime dataHoraExclusao;
	
	@Column(nullable=false)
	@Enumerated(EnumType.ORDINAL)
	private Perfil perfil;
	@OneToOne
	@JoinColumn(name = "id_dados_profissionais")
	private DadosProfissionais dadosProfissionais;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public LocalDateTime getDataHoraCadastro() {
		return dataHoraCadastro;
	}
	public void setDataHoraCadastro(LocalDateTime dataHoraCadastro) {
		this.dataHoraCadastro = dataHoraCadastro;
	}
	public LocalDateTime getDataHoraAlteracao() {
		return dataHoraAlteracao;
	}
	public void setDataHoraAlteracao(LocalDateTime dataHoraAlteracao) {
		this.dataHoraAlteracao = dataHoraAlteracao;
	}
	public LocalDateTime getDataHoraExclusao() {
		return dataHoraExclusao;
	}
	public void setDataHoraExclusao(LocalDateTime dataHoraExclusao) {
		this.dataHoraExclusao = dataHoraExclusao;
	}
	public Perfil getPerfil() {
		return perfil;
	}
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	public DadosProfissionais getDadosProfissionais() {
		return dadosProfissionais;
	}
	public void setDadosProfissionais(DadosProfissionais dadosProfissionais) {
		this.dadosProfissionais = dadosProfissionais;
	}

}