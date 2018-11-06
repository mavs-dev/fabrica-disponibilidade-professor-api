package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.model.PeriodoPlanejamento;

public interface PeriodoPlanejamentoRepository extends JpaRepository<PeriodoPlanejamento, Long> {

}
