package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.models.Titulacao;

public interface TitulacaoRepository extends JpaRepository<Titulacao, Long>{

	public Titulacao findByDescricao(String descricao);
}
