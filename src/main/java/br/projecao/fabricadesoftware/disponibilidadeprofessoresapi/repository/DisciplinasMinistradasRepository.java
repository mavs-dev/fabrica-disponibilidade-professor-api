package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.models.DisciplinasMinistradas;

public interface DisciplinasMinistradasRepository extends JpaRepository<DisciplinasMinistradas, String> {

}
