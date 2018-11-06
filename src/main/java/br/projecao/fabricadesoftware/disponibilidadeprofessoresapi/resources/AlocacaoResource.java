package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.model.Alocacao;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.repository.AlocacaoRepository;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources.interfaces.Resource;

@RestController
@RequestMapping(value = "/alocacao", produces = MediaType.APPLICATION_JSON_VALUE)
public class AlocacaoResource implements Resource<Alocacao> {

	@Autowired
	private AlocacaoRepository repository;
	
	@Override
	public void fillInBlankFields(Alocacao entity) {

	}

	@Override
	public void merge(Alocacao newEntity, Alocacao oldEntity) {

	}

	@Override
	public JpaRepository<Alocacao, Long> getRepository() {
		return repository;
	}

	@Override
	public void executaAntesDeCadastrar(Alocacao entity) {
		entity.setDataHoraCadastro(LocalDateTime.now());
	}

	@Override
	public void executaAntesDeAtualizarParcialMente(Long id, Alocacao entity) {
		entity.setId(id);
		entity.setDataHoraAlteracao(LocalDateTime.now());
		fillInBlankFields(entity);
	}

	@Override
	public void executaAntesDeAtualizarTotalmente(Long id, Alocacao entity) {
		entity.setId(id);
		entity.setDataHoraAlteracao(LocalDateTime.now());
	}

	@Override
	public void executaAntesDeDeletar(Long id) {
	}

	@Override
	public boolean isInvalidoParaAtualizacao(Long id, Alocacao entity) {
		return entity.getId() == null || entity.getId().longValue() <= 0;
	}

}
