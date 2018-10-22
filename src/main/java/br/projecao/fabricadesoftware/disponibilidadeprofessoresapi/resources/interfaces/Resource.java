package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * M1 será subistituido pela model informada na classe que implementará essa interface.
 * */
@RestController
public interface Resource<M1> {

	@GetMapping
	default ResponseEntity<List<M1>> getAll() {
		List<M1> lista = null;
		HttpStatus status = HttpStatus.OK;
		try {
			lista = getRepository().findAll();
			if (lista == null || lista.isEmpty()) {
				status = HttpStatus.NO_CONTENT;
			}
		} catch (Exception e) {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			e.printStackTrace();
		}
		return new ResponseEntity<>(lista, status);
	}

	@GetMapping
	@RequestMapping(value = "/{id}")
	default ResponseEntity<Optional<M1>> getOne(@PathVariable("id") Long id) {
		Optional<M1> model = null;
		HttpStatus status = HttpStatus.OK;
		try {
			model = getRepository().findById(id);
			if (!model.isPresent()) {
				model = null;
				status = HttpStatus.NO_CONTENT;
			}
		} catch (Exception e) {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			e.printStackTrace();
		}
		return new ResponseEntity<>(model, status);
	}

	@PostMapping
	default ResponseEntity<M1> post(@RequestBody M1 entity) {
		HttpStatus status = HttpStatus.CREATED;
		executaAntesDeCadastrar(entity);
		try {
			getRepository().save(entity);
		} catch (Exception e) {
			status = HttpStatus.NOT_MODIFIED;
			e.printStackTrace();
		}
		return new ResponseEntity<>(entity, status);
	}

	@PatchMapping(value = "/{id}")
	default ResponseEntity<M1> patch(@PathVariable("id") Long id, @RequestBody M1 entity) {
		/*HttpStatus status = HttpStatus.ACCEPTED;
		try {
			if(isInvalidoParaAtualizacao(id, entity)) {
				status = HttpStatus.NOT_MODIFIED;
			} else {
				getRepository().save(entity);
			}
		}catch(Exception e) {
			status = HttpStatus.NOT_MODIFIED;
			e.printStackTrace();
		}*/
		return new ResponseEntity<>(entity, HttpStatus.NOT_IMPLEMENTED);
	}

	@PutMapping(value = "/{id}")
	default ResponseEntity<M1> put(@PathVariable("id") Long id, @RequestBody M1 entity) {
		HttpStatus status = HttpStatus.ACCEPTED;
		executaAntesDeAtualizarTotalmente(id, entity);
		try {
			if(isInvalidoParaAtualizacao(id, entity)) {
				status = HttpStatus.NOT_MODIFIED;
			} else {
				getRepository().save(entity);
			}
		} catch (Exception e) {
			status = HttpStatus.NOT_MODIFIED;
			e.printStackTrace();
		}
		return new ResponseEntity<>(entity, status);
	}

	@DeleteMapping(value = "/{id}")
	default ResponseEntity<M1> delete(@PathVariable("id") Long id) {
		HttpStatus status = HttpStatus.NO_CONTENT;
		executaAntesDeDeletar(id);
		try {
			if (getRepository().existsById(id)) {
				getRepository().deleteById(id);
			} else {
				status = HttpStatus.NOT_MODIFIED;
			}
		} catch (Exception e) {
			status = HttpStatus.NOT_MODIFIED;
			e.printStackTrace();
		}
		return new ResponseEntity<>(null, status);
	}

	void fillInBlankFields(M1 entity);
	void merge(M1 newEntity, M1 oldEntity);
	JpaRepository<M1, Long> getRepository();
	void executaAntesDeCadastrar(M1 entity);
	void executaAntesDeAtualizarParcialMente(Long id, M1 entity);
	void executaAntesDeAtualizarTotalmente(Long id,M1 entity);
	void executaAntesDeDeletar(Long id);
	boolean isInvalidoParaAtualizacao(Long id, M1 entity);
}
