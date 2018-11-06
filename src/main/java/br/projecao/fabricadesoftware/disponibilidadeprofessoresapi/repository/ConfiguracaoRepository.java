package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.model.Configuracao;

public interface ConfiguracaoRepository extends JpaRepository<Configuracao, Long> {

}
