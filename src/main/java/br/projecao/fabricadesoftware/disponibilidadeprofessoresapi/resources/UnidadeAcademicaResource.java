package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.model.UnidadeAcademica;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.repository.UnidadeAcademicaRepository;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources.interfaces.Resource;

@RestController
@RequestMapping(value = "/unidade-academica", produces = MediaType.APPLICATION_JSON_VALUE)
public class UnidadeAcademicaResource implements Resource<UnidadeAcademica> {

	@Autowired
	private UnidadeAcademicaRepository repository;

	@Override
	public void fillInBlankFields(UnidadeAcademica entity) {

	}

	@Override
	public void merge(UnidadeAcademica newEntity, UnidadeAcademica oldEntity) {

	}

	@Override
	public JpaRepository<UnidadeAcademica, Long> getRepository() {
		return this.repository;
	}

	@Override
	public void executaAntesDeCadastrar(UnidadeAcademica entity) {
		entity.setDataHoraCadastro(LocalDateTime.now());
	}

	@Override
	public void executaAntesDeAtualizarParcialMente(Long id, UnidadeAcademica entity) {
		entity.setId(id);
		entity.setDataHoraAlteracao(LocalDateTime.now());
		fillInBlankFields(entity);
	}

	@Override
	public void executaAntesDeAtualizarTotalmente(Long id, UnidadeAcademica entity) {
		entity.setId(id);
		entity.setDataHoraAlteracao(LocalDateTime.now());
	}

	@Override
	public void executaAntesDeDeletar(Long id) {
		
	}

	@Override
	public boolean isInvalidoParaAtualizacao(Long id, UnidadeAcademica entity) {
		return entity.getId() == null || entity.getId().longValue() <= 0;
	}
}
