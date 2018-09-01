package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.models.Professor;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.repository.ProfessorRepository;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources.interfaces.Resource;

@RestController
@RequestMapping(value="/professor", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
public class ProfessorResource implements Resource<Professor>{
	
	@Autowired
	HttpServletRequest servlet;
	
	@Autowired
	private ProfessorRepository repository;
	
	public ResponseEntity<List<Professor>> getAll() {
		List<Professor> lista = repository.findAll();
		HttpStatus status = HttpStatus.OK;
		if(lista == null || lista.isEmpty()) {
			status = HttpStatus.NO_CONTENT;
		}
		return new ResponseEntity<List<Professor>>(lista, status);
	}
	
	public ResponseEntity<Optional<Professor>> getOne(Long id) {
		Optional<Professor> model = repository.findById(id);
		HttpStatus status = HttpStatus.OK;
		if(!model.isPresent()) {
			status = HttpStatus.NO_CONTENT;
		}
		return new ResponseEntity<Optional<Professor>>(model, status);
	}
	
	public ResponseEntity<Professor> post(@RequestBody @Valid Professor entity) {
		MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
		HttpStatus status = HttpStatus.CREATED;
		try {
			repository.save(entity);
		}catch(Exception e) {
			status = HttpStatus.NOT_MODIFIED;
			Professor professor = repository.findByEmail(entity.getEmail());
			header.set(HttpHeaders.LINK, servlet.getRequestURL()+"/"+professor.getId().toString());
			header.set(HttpHeaders.WARNING, e.getMessage());
		}
		return new ResponseEntity<>(null, header, status);
	}
	
	public ResponseEntity<Professor> patch(@PathVariable("id") Long id, @RequestBody Professor entity) {
		entity.setId(id);
		fillInBlankFields(entity);
		repository.save(entity);
		HttpStatus status = HttpStatus.ACCEPTED;
		if(entity.getId() == null || entity.getId().longValue() <= 0) {
			status = HttpStatus.NOT_MODIFIED;
		}
		return new ResponseEntity<>(null, status);
	}
	
	public ResponseEntity<Professor> put(@PathVariable("id") Long id, @RequestBody Professor entity) {
		entity.setId(id);
		repository.save(entity);
		HttpStatus status = HttpStatus.ACCEPTED;
		if(entity.getId() == null || entity.getId().longValue() <= 0) {
			status = HttpStatus.NOT_MODIFIED;
		}
		return new ResponseEntity<>(null, status);
	}
	
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
