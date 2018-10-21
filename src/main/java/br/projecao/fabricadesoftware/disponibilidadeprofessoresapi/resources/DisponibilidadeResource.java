package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.model.Disponibilidade;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.repository.DisponibilidadeRepository;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources.interfaces.Resource;

@RestController
@RequestMapping(value = "/disponibilidade", produces = MediaType.APPLICATION_JSON_VALUE)
public class DisponibilidadeResource implements Resource<Disponibilidade> {

	@Autowired
	private DisponibilidadeRepository repository;

	@Override
	public void fillInBlankFields(Disponibilidade entity) {

	}

	@Override
	public void merge(Disponibilidade newEntity, Disponibilidade oldEntity) {

	}

	@Override
	public JpaRepository<Disponibilidade, Long> getRepository() {
		return this.repository;
	}

	@Override
	public void executaAntesDeCadastrar(Disponibilidade entity) {
		entity.setDataHoraCadastro(LocalDateTime.now());
	}

	@Override
	public void executaAntesDeAtualizarParcialMente(Long id, Disponibilidade entity) {
		entity.setId(id);
		entity.setDataHoraAlteracao(LocalDateTime.now());
		fillInBlankFields(entity);
	}

	@Override
	public void executaAntesDeAtualizarTotalmente(Long id, Disponibilidade entity) {
		entity.setId(id);
		entity.setDataHoraAlteracao(LocalDateTime.now());
	}

	@Override
	public void executaAntesDeDeletar(Long id) {
		
	}

	@Override
	public boolean isInvalidoParaAtualizacao(Long id, Disponibilidade entity) {
		return entity.getId() == null || entity.getId().longValue() <= 0;
	}

}
