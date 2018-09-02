package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.models.AreaDeConhecimento;

public interface AreaDeConhecimentoRepository extends JpaRepository<AreaDeConhecimento, Long> {

	public AreaDeConhecimento findByDescricao(String descricao);
}
