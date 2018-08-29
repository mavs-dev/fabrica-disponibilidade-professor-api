package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.models.Professor;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.repository.ProfessorRepository;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources.interfaces.Resource;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(value="/professor", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
public class ProfessorResource implements Resource<Professor>{
	
	@Autowired
	private ProfessorRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Professor>> listAll() {
		List<Professor> listaProfessores = repository.findAll();
		HttpStatus status = HttpStatus.OK;
		if(listaProfessores == null || listaProfessores.isEmpty()) {
			status = HttpStatus.NO_CONTENT;
		}
		return new ResponseEntity<List<Professor>>(listaProfessores, status);
	}
	
	@GetMapping
	@RequestMapping(value ="/{id}")
	public ResponseEntity<Optional<Professor>> listOne(@PathVariable("id") Long id) {
		Optional<Professor> professor = repository.findById(id);
		HttpStatus status = HttpStatus.OK;
		if(!professor.isPresent()) {
			status = HttpStatus.NO_CONTENT;
		}
		return new ResponseEntity<Optional<Professor>>(professor, status);
	}
	
	@PostMapping
	public ResponseEntity<Professor> create(@RequestBody @Valid Professor entity) {
		repository.save(entity);
		HttpStatus status = HttpStatus.CREATED;
		MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
		if(entity.getId() == null || entity.getId().longValue() <= 0) {
			status = HttpStatus.NOT_MODIFIED;
			header.set(HttpHeaders.LOCATION, entity.getId().toString());
		}
		
		return new ResponseEntity<>(null, header, status);
	}
	
	@PatchMapping(value="/{id}")
	public ResponseEntity<Professor> update(@PathVariable("id") Long id, @RequestBody Professor entity) {
		entity.setId(id);
		fillInBlankFields(entity);
		repository.save(entity);
		HttpStatus status = HttpStatus.ACCEPTED;
		if(entity.getId() == null || entity.getId().longValue() <= 0) {
			status = HttpStatus.NOT_MODIFIED;
		}
		return new ResponseEntity<>(null, status);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Professor> delete(@PathVariable("id") Long id) {
		HttpStatus status = HttpStatus.NO_CONTENT;
		if(repository.existsById(id)) {
			repository.deleteById(id);
		}else {
			status = HttpStatus.NOT_MODIFIED;
		}
		return new ResponseEntity<>(null, status);
	}
	
	public void fillInBlankFields(Professor entity) {
		Professor oldEntity = repository.findById(entity.getId()).get();
		merge(entity, oldEntity);
	}
	
	public void merge(Professor newEntity, Professor oldEntity) {
		//dados pessoais
		newEntity.setNome((newEntity.getNome() !=null && !newEntity.getNome().isEmpty())? newEntity.getNome(): oldEntity.getNome());
		newEntity.setSobrenome((newEntity.getSobrenome() !=null && !newEntity.getSobrenome().isEmpty())? newEntity.getSobrenome(): oldEntity.getSobrenome());
		newEntity.setApelido((newEntity.getApelido() !=null && !newEntity.getApelido().isEmpty())? newEntity.getApelido(): oldEntity.getApelido());
		newEntity.setEndereco((newEntity.getEndereco() !=null && !newEntity.getEndereco().isEmpty())? newEntity.getEndereco(): oldEntity.getEndereco());
		newEntity.setCidade((newEntity.getCidade() !=null && !newEntity.getCidade().isEmpty())? newEntity.getCidade(): oldEntity.getCidade());
		newEntity.setCep((newEntity.getCep() !=null && !newEntity.getCep().isEmpty())? newEntity.getCep(): oldEntity.getCep());
		newEntity.setTelefone((newEntity.getTelefone() !=null && !newEntity.getTelefone().isEmpty())? newEntity.getTelefone(): oldEntity.getTelefone());
		newEntity.setCelular((newEntity.getCelular() !=null && !newEntity.getCelular().isEmpty())? newEntity.getCelular(): oldEntity.getCelular());
		newEntity.setEmail((newEntity.getEmail() !=null && !newEntity.getEmail().isEmpty())? newEntity.getEmail(): oldEntity.getEmail());
		
		//dados profissionais
		newEntity.setDataConclusao((newEntity.getDataConclusao() !=null && !newEntity.getDataConclusao().toString().isEmpty())? newEntity.getDataConclusao(): oldEntity.getDataConclusao());
		newEntity.setPrincipalAtuacaoProfissional((newEntity.getPrincipalAtuacaoProfissional() !=null && !newEntity.getPrincipalAtuacaoProfissional().isEmpty())? newEntity.getPrincipalAtuacaoProfissional(): oldEntity.getPrincipalAtuacaoProfissional());
		newEntity.setTempoExpProfissional((newEntity.getTempoExpProfissional() !=null)? newEntity.getTempoExpProfissional(): oldEntity.getTempoExpProfissional());
		newEntity.setTempoExpEmMagisterioSuperior((newEntity.getTempoExpEmMagisterioSuperior() !=null)? newEntity.getTempoExpEmMagisterioSuperior(): oldEntity.getTempoExpEmMagisterioSuperior());
		newEntity.setTempoExpDocenciaNaEdBasica((newEntity.getTempoExpDocenciaNaEdBasica() !=null)? newEntity.getTempoExpDocenciaNaEdBasica(): oldEntity.getTempoExpDocenciaNaEdBasica());
	}	
}
