package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.model.Disciplina;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.repository.DisciplinaRepository;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources.interfaces.Resource;

@RestController
@RequestMapping(value = "/disciplina", produces = MediaType.APPLICATION_JSON_VALUE)
public class DisciplinaResource implements Resource<Disciplina> {

	@Autowired
	private DisciplinaRepository repository;

	@Override
	public void fillInBlankFields(Disciplina entity) {

	}

	@Override
	public void merge(Disciplina newEntity, Disciplina oldEntity) {

	}

	@Override
	public JpaRepository<Disciplina, Long> getRepository() {
		return this.repository;
	}

	@Override
	public void executaAntesDeCadastrar(Disciplina entity) {
		entity.setDataHoraCadastro(LocalDateTime.now());
	}

	@Override
	public void executaAntesDeAtualizarParcialMente(Long id, Disciplina entity) {
		entity.setId(id);
		entity.setDataHoraAlteracao(LocalDateTime.now());
		fillInBlankFields(entity);
	}

	@Override
	public void executaAntesDeAtualizarTotalmente(Long id, Disciplina entity) {
		entity.setId(id);
		entity.setDataHoraAlteracao(LocalDateTime.now());
	}

	@Override
	public void executaAntesDeDeletar(Long id) {
		
	}

	@Override
	public boolean isInvalidoParaAtualizacao(Long id, Disciplina entity) {
		return entity.getId() == null || entity.getId().longValue() <= 0;
	}

}
