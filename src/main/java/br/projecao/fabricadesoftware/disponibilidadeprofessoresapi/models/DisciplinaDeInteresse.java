package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.dominio.Turno;

@Entity
@Table(name = "DISCIPLINA_DE_INTERESSE")
public class DisciplinaDeInteresse {

	@Id
	@SequenceGenerator(name = "dp_seq_disc_inter", sequenceName="dp_seq_disc_inter")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(length = 4)
	private Integer ano;
	
	@Column(length = 1)
	private Integer semestre;
	
	private Disciplina disciplina;
	
	private Turno turno;
	
	private UnidadeAcademica unidadeAcademica;
	
	private Professor professor;
	
}
