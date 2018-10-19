package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.model.Disponibilidade;

public interface DisponibilidadeRepository extends JpaRepository<Disponibilidade, Long> {

}
