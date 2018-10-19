package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.model.DadosProfissionais;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources.interfaces.Resource;

@RestController
@RequestMapping(value = "/dados-profissionais", produces = MediaType.APPLICATION_JSON_VALUE)
public class DadosProfissionaisResource implements Resource<DadosProfissionais> {

	@Override
	public ResponseEntity<List<DadosProfissionais>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Optional<DadosProfissionais>> getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<DadosProfissionais> post(DadosProfissionais entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<DadosProfissionais> patch(Long id, DadosProfissionais entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<DadosProfissionais> put(Long id, DadosProfissionais entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<DadosProfissionais> delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void fillInBlankFields(DadosProfissionais entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void merge(DadosProfissionais newEntity, DadosProfissionais oldEntity) {
		// TODO Auto-generated method stub

	}

}
