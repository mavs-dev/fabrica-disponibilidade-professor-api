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


@RestController
public interface Resource<Model> {

	@GetMapping
	default ResponseEntity<List<Model>> getAll() {
		List<Model> lista = null;
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
		return new ResponseEntity<List<Model>>(lista, status);
	}

	@GetMapping
	@RequestMapping(value = "/{id}")
	default ResponseEntity<Optional<Model>> getOne(@PathVariable("id") Long id) {
		Optional<Model> model = null;
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
		return new ResponseEntity<Optional<Model>>(model, status);
	}

	@PostMapping
	default ResponseEntity<Model> post(@RequestBody Model entity) {
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
	default ResponseEntity<Model> patch(@PathVariable("id") Long id, @RequestBody Model entity) {
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
		return new ResponseEntity<Model>(entity, HttpStatus.NOT_IMPLEMENTED);
	}

	@PutMapping(value = "/{id}")
	default ResponseEntity<Model> put(@PathVariable("id") Long id, @RequestBody Model entity) {
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
	default ResponseEntity<Model> delete(@PathVariable("id") Long id) {
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

	void fillInBlankFields(Model entity);
	void merge(Model newEntity, Model oldEntity);
	JpaRepository<Model, Long> getRepository();
	void executaAntesDeCadastrar(Model entity);
	void executaAntesDeAtualizarParcialMente(Long id, Model entity);
	void executaAntesDeAtualizarTotalmente(Long id,Model entity);
	void executaAntesDeDeletar(Long id);
	boolean isInvalidoParaAtualizacao(Long id, Model entity);
}
