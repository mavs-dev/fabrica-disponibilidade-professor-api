package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.model.CurriculoLattes;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources.interfaces.Resource;

@RestController
@RequestMapping(value = "/curriculo-lattes", produces = MediaType.APPLICATION_JSON_VALUE)
public class CurriculoLattesResource implements Resource<CurriculoLattes> {

	@Override
	public ResponseEntity<List<CurriculoLattes>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Optional<CurriculoLattes>> getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<CurriculoLattes> post(CurriculoLattes entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<CurriculoLattes> patch(Long id, CurriculoLattes entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<CurriculoLattes> put(Long id, CurriculoLattes entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<CurriculoLattes> delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void fillInBlankFields(CurriculoLattes entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void merge(CurriculoLattes newEntity, CurriculoLattes oldEntity) {
		// TODO Auto-generated method stub

	}

}
