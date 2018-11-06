package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.model.PeriodoPreenchimento;

public interface PeriodoPreenchimentoRepository extends JpaRepository<PeriodoPreenchimento, Long> {

}
