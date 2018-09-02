package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.models.TipoUsuario;

public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Long>{

	public TipoUsuario findByDescricao(String descricao);
}
