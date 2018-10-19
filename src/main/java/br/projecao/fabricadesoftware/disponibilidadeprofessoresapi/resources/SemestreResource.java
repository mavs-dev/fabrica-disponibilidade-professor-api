package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.model.Semestre;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources.interfaces.Resource;

@RestController
@RequestMapping(value = "/semestre", produces = MediaType.APPLICATION_JSON_VALUE)
public class SemestreResource implements Resource<Semestre> {

	@Override
	public ResponseEntity<List<Semestre>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Optional<Semestre>> getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Semestre> post(Semestre entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Semestre> patch(Long id, Semestre entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Semestre> put(Long id, Semestre entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Semestre> delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void fillInBlankFields(Semestre entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void merge(Semestre newEntity, Semestre oldEntity) {
		// TODO Auto-generated method stub

	}

}
