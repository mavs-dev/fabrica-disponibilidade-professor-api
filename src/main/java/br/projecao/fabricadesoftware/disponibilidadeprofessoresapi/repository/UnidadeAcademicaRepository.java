package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.models.UnidadeAcademica;

public interface UnidadeAcademicaRepository extends JpaRepository<UnidadeAcademica, Long> {

	public UnidadeAcademica findByNome(String nome);
}
