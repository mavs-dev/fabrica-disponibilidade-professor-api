package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.model.Configuracao;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.repository.ConfiguracaoRepository;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources.interfaces.Resource;

@RestController
@RequestMapping(value = "/configuracao", produces = MediaType.APPLICATION_JSON_VALUE)
public class ConfiguracaoResource implements Resource<Configuracao> {
	
	@Autowired
	private ConfiguracaoRepository repository;

	@Override
	public void fillInBlankFields(Configuracao entity) {
	}

	@Override
	public void merge(Configuracao newEntity, Configuracao oldEntity) {
	}

	@Override
	public JpaRepository<Configuracao, Long> getRepository() {
		return repository;
	}

	@Override
	public void executaAntesDeCadastrar(Configuracao entity) {
		entity.setDataHoraCadastro(LocalDateTime.now());
	}

	@Override
	public void executaAntesDeAtualizarParcialMente(Long id, Configuracao entity) {
		entity.setId(id);
		entity.setDataHoraAlteracao(LocalDateTime.now());
		fillInBlankFields(entity);
	}

	@Override
	public void executaAntesDeAtualizarTotalmente(Long id, Configuracao entity) {
		entity.setId(id);
		entity.setDataHoraAlteracao(LocalDateTime.now());
	}

	@Override
	public void executaAntesDeDeletar(Long id) {
	}

	@Override
	public boolean isInvalidoParaAtualizacao(Long id, Configuracao entity) {
		return entity.getId() == null || entity.getId().longValue() <= 0;
	}

}
