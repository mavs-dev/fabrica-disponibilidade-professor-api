package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.model.PeriodoPlanejamento;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.repository.PeriodoPlanejamentoRepository;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources.interfaces.Resource;

@RestController
@RequestMapping(value = "/periodo-planejamento", produces = MediaType.APPLICATION_JSON_VALUE)
public class PeriodoPlanejamentoResource implements Resource<PeriodoPlanejamento> {

	@Autowired
	private PeriodoPlanejamentoRepository repository;
	
	@Override
	public void fillInBlankFields(PeriodoPlanejamento entity) {
	}

	@Override
	public void merge(PeriodoPlanejamento newEntity, PeriodoPlanejamento oldEntity) {
	}

	@Override
	public JpaRepository<PeriodoPlanejamento, Long> getRepository() {
		return repository;
	}

	@Override
	public void executaAntesDeCadastrar(PeriodoPlanejamento entity) {
		entity.setDataHoraCadastro(LocalDateTime.now());
	}

	@Override
	public void executaAntesDeAtualizarParcialMente(Long id, PeriodoPlanejamento entity) {
		entity.setId(id);
		entity.setDataHoraAlteracao(LocalDateTime.now());
		fillInBlankFields(entity);
	}

	@Override
	public void executaAntesDeAtualizarTotalmente(Long id, PeriodoPlanejamento entity) {
		entity.setId(id);
		entity.setDataHoraAlteracao(LocalDateTime.now());
	}

	@Override
	public void executaAntesDeDeletar(Long id) {
	}

	@Override
	public boolean isInvalidoParaAtualizacao(Long id, PeriodoPlanejamento entity) {
		return entity.getId() == null || entity.getId().longValue() <= 0;
	}

}
