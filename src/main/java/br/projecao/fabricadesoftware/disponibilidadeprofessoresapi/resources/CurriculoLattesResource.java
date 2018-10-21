package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.model.CurriculoLattes;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.repository.CurriculoLattesRepository;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources.interfaces.Resource;

@RestController
@RequestMapping(value = "/curriculo-lattes", produces = MediaType.APPLICATION_JSON_VALUE)
public class CurriculoLattesResource implements Resource<CurriculoLattes> {
	
	@Autowired
	private CurriculoLattesRepository repository;

	@Override
	public void fillInBlankFields(CurriculoLattes entity) {

	}

	@Override
	public void merge(CurriculoLattes newEntity, CurriculoLattes oldEntity) {

	}

	@Override
	public JpaRepository<CurriculoLattes, Long> getRepository() {
		return this.repository;
	}

	@Override
	public void executaAntesDeCadastrar(CurriculoLattes entity) {
		entity.setDataHoraCadastro(LocalDateTime.now());
	}

	@Override
	public void executaAntesDeAtualizarParcialMente(Long id, CurriculoLattes entity) {
		entity.setId(id);
		entity.setDataHoraAlteracao(LocalDateTime.now());
		fillInBlankFields(entity);
	}

	@Override
	public void executaAntesDeAtualizarTotalmente(Long id, CurriculoLattes entity) {
		entity.setId(id);
		entity.setDataHoraAlteracao(LocalDateTime.now());
	}

	@Override
	public void executaAntesDeDeletar(Long id) {
		
	}

	@Override
	public boolean isInvalidoParaAtualizacao(Long id, CurriculoLattes entity) {
		return entity.getId() == null || entity.getId().longValue() <= 0;
	}
}
