package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TITULACAO")
public class Titulacao {

	@Id
	@SequenceGenerator(name = "dp_seq_titulacao", sequenceName = "dp_seq_titulacao")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(length = 45)
	private String descricao;

	private Boolean titulacaoEmAndamento;
	private Boolean maiorTitulacaoObtida;
	private LocalDate dataTermino;
	
	@ManyToOne
	@JoinColumn(name = "usuario")
	private Usuario usuario;
}
