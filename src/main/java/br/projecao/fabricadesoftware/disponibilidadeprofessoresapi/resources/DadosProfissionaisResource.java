package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.model.DadosProfissionais;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.repository.DadosProfissionaisRepository;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources.interfaces.Resource;

@RestController
@RequestMapping(value = "/dados-profissionais", produces = MediaType.APPLICATION_JSON_VALUE)
public class DadosProfissionaisResource implements Resource<DadosProfissionais> {

	@Autowired
	private DadosProfissionaisRepository repository;

	@Override
	public void fillInBlankFields(DadosProfissionais entity) {

	}

	@Override
	public void merge(DadosProfissionais newEntity, DadosProfissionais oldEntity) {

	}

	@Override
	public JpaRepository<DadosProfissionais, Long> getRepository() {
		return this.repository;
	}

	@Override
	public void executaAntesDeCadastrar(DadosProfissionais entity) {
		System.out.println(entity.getProfessor());
		System.out.println(entity.getProfessor().getId());
		entity.setDataHoraCadastro(LocalDateTime.now());
	}

	@Override
	public void executaAntesDeAtualizarParcialMente(Long id, DadosProfissionais entity) {
		entity.setId(id);
		entity.setDataHoraAlteracao(LocalDateTime.now());
		fillInBlankFields(entity);
	}

	@Override
	public void executaAntesDeAtualizarTotalmente(Long id, DadosProfissionais entity) {
		entity.setId(id);
		entity.setDataHoraAlteracao(LocalDateTime.now());
	}

	@Override
	public void executaAntesDeDeletar(Long id) {
		
	}

	@Override
	public boolean isInvalidoParaAtualizacao(Long id, DadosProfissionais entity) {
		return entity.getId() == null || entity.getId().longValue() <= 0;
	}
	
}
