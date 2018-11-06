package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.model.PeriodoPreenchimento;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.repository.PeriodoPreenchimentoRepository;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources.interfaces.Resource;

@RestController
@RequestMapping(value = "/periodo-preenchimento", produces = MediaType.APPLICATION_JSON_VALUE)
public class PeriodoPreenchimentoResource implements Resource<PeriodoPreenchimento> {

	@Autowired
	private PeriodoPreenchimentoRepository repository;
	
	@Override
	public void fillInBlankFields(PeriodoPreenchimento entity) {
	}

	@Override
	public void merge(PeriodoPreenchimento newEntity, PeriodoPreenchimento oldEntity) {
	}

	@Override
	public JpaRepository<PeriodoPreenchimento, Long> getRepository() {
		return this.repository;
	}

	@Override
	public void executaAntesDeCadastrar(PeriodoPreenchimento entity) {
		entity.setDataHoraCadastro(LocalDateTime.now());
	}

	@Override
	public void executaAntesDeAtualizarParcialMente(Long id, PeriodoPreenchimento entity) {
		entity.setId(id);
		entity.setDataHoraAlteracao(LocalDateTime.now());
		fillInBlankFields(entity);
	}

	@Override
	public void executaAntesDeAtualizarTotalmente(Long id, PeriodoPreenchimento entity) {
		entity.setId(id);
		entity.setDataHoraAlteracao(LocalDateTime.now());
	}

	@Override
	public void executaAntesDeDeletar(Long id) {
	}

	@Override
	public boolean isInvalidoParaAtualizacao(Long id, PeriodoPreenchimento entity) {
		return entity.getId() == null || entity.getId().longValue() <= 0;
	}

}
