package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.models.CurriculoLattes;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.models.Professor;

public interface CurriculoLattesRepository extends JpaRepository<CurriculoLattes, Long>{

	public CurriculoLattes findByProfessor(Professor professor);
}
