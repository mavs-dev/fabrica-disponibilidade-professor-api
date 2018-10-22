package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.model.Interesse;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.repository.InteresseRepository;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources.interfaces.Resource;

@RestController
@RequestMapping(value = "/interesse", produces = MediaType.APPLICATION_JSON_VALUE)
public class InteresseResource implements Resource<Interesse> {

	@Autowired
	private InteresseRepository repository;

	@Override
	public void fillInBlankFields(Interesse entity) {

	}

	@Override
	public void merge(Interesse newEntity, Interesse oldEntity) {

	}

	@Override
	public JpaRepository<Interesse, Long> getRepository() {
		return this.repository;
	}

	@Override
	public void executaAntesDeCadastrar(Interesse entity) {
		entity.setDataHoraCadastro(LocalDateTime.now());
	}

	@Override
	public void executaAntesDeAtualizarParcialMente(Long id, Interesse entity) {
		entity.setId(id);
		entity.setDataHoraAlteracao(LocalDateTime.now());
		fillInBlankFields(entity);
	}

	@Override
	public void executaAntesDeAtualizarTotalmente(Long id, Interesse entity) {
		entity.setId(id);
		entity.setDataHoraAlteracao(LocalDateTime.now());
	}

	@Override
	public void executaAntesDeDeletar(Long id) {
		
	}

	@Override
	public boolean isInvalidoParaAtualizacao(Long id, Interesse entity) {
		return entity.getId() == null || entity.getId().longValue() <= 0;
	}

}
