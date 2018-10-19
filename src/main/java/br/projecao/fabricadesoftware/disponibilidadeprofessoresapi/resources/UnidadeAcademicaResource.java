package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.model.UnidadeAcademica;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources.interfaces.Resource;

@RestController
@RequestMapping(value = "/unidade-academica", produces = MediaType.APPLICATION_JSON_VALUE)
public class UnidadeAcademicaResource implements Resource<UnidadeAcademica> {

	@Override
	public ResponseEntity<List<UnidadeAcademica>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Optional<UnidadeAcademica>> getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<UnidadeAcademica> post(UnidadeAcademica entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<UnidadeAcademica> patch(Long id, UnidadeAcademica entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<UnidadeAcademica> put(Long id, UnidadeAcademica entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<UnidadeAcademica> delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void fillInBlankFields(UnidadeAcademica entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void merge(UnidadeAcademica newEntity, UnidadeAcademica oldEntity) {
		// TODO Auto-generated method stub

	}

}
