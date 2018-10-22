package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.model.Semestre;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.repository.SemestreRepository;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources.interfaces.Resource;

@RestController
@RequestMapping(value = "/semestre", produces = MediaType.APPLICATION_JSON_VALUE)
public class SemestreResource implements Resource<Semestre> {

	@Autowired
	private SemestreRepository repository;

	@Override
	public void fillInBlankFields(Semestre entity) {

	}

	@Override
	public void merge(Semestre newEntity, Semestre oldEntity) {

	}

	@Override
	public JpaRepository<Semestre, Long> getRepository() {
		return this.repository;
	}

	@Override
	public void executaAntesDeCadastrar(Semestre entity) {
		entity.setDataHoraCadastro(LocalDateTime.now());
	}

	@Override
	public void executaAntesDeAtualizarParcialMente(Long id, Semestre entity) {
		entity.setId(id);
		entity.setDataHoraAlteracao(LocalDateTime.now());
		fillInBlankFields(entity);
	}

	@Override
	public void executaAntesDeAtualizarTotalmente(Long id, Semestre entity) {
		entity.setId(id);
		entity.setDataHoraAlteracao(LocalDateTime.now());
	}

	@Override
	public void executaAntesDeDeletar(Long id) {
		
	}

	@Override
	public boolean isInvalidoParaAtualizacao(Long id, Semestre entity) {
		return entity.getId() == null || entity.getId().longValue() <= 0;
	}

}
