package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.models.Usuario;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources.interfaces.Resource;

public class UsuarioResource implements Resource<Usuario>{

	@Override
	public ResponseEntity<List<Usuario>> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Optional<Usuario>> listOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Usuario> create(Usuario entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Usuario> update(Long id, Usuario entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Usuario> delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void fillInBlankFields(Usuario entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void merge(Usuario newEntity, Usuario oldEntity) {
		// TODO Auto-generated method stub
		
	}

}
