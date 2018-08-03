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
	private ProfessorRepository pr;
	
	@GetMapping()
	public ResponseEntity<List<Professor>> listAll() {
		List<Professor> listaProfessores = pr.findAll();
		HttpStatus status = HttpStatus.OK;
		if(listaProfessores == null || listaProfessores.isEmpty()) {
			status = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<List<Professor>>(listaProfessores, status);
	}
	
	@GetMapping()
	@RequestMapping(value ="/{id}")
	public ResponseEntity<Optional<Professor>> listOne(@PathVariable("id") String id) {
		Optional<Professor> professor = pr.findById(id);
		HttpStatus status = HttpStatus.OK;
		if(!professor.isPresent()) {
			status = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<Optional<Professor>>(professor, status);
	}
	
	@PostMapping()
	public ResponseEntity<Professor> create(@RequestBody @Valid Professor professor) {
		pr.save(professor);
		HttpStatus status = HttpStatus.CREATED;
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
		if(professor.getId() == null || professor.getId().isEmpty()) {
			status = HttpStatus.NOT_MODIFIED;
			headers.set(HttpHeaders.LOCATION, professor.getId());
		}
		
		return new ResponseEntity<>(null, headers, status);
	}
	
	@PatchMapping(value="/{id}")
	public ResponseEntity<Professor> update(@PathVariable("id") String id, @RequestBody Professor professor) {
		professor.setId(id);
		fillInBlankFields(professor);
		pr.save(professor);
		HttpStatus status = HttpStatus.ACCEPTED;
		if(professor.getId() == null || professor.getId().isEmpty()) {
			status = HttpStatus.NOT_MODIFIED;
		}
		return new ResponseEntity<>(null, status);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Professor> delete(@PathVariable("id") String id) {
		HttpStatus status = HttpStatus.NO_CONTENT;
		if(pr.existsById(id)) {
			pr.deleteById(id);
		}else {
			status = HttpStatus.NOT_MODIFIED;
		}
		return new ResponseEntity<>(null, status);
	}
	
	public void fillInBlankFields(Professor professor) {
		Professor professorAtual = pr.findById(professor.getId()).get();
		merge(professor, professorAtual);
	}
	
	public void merge(Professor novoProfessor, Professor professorAtual) {
		//dados pessoais
		novoProfessor.setNome((novoProfessor.getNome() !=null && !novoProfessor.getNome().isEmpty())? novoProfessor.getNome(): professorAtual.getNome());
		novoProfessor.setSobrenome((novoProfessor.getSobrenome() !=null && !novoProfessor.getSobrenome().isEmpty())? novoProfessor.getSobrenome(): professorAtual.getSobrenome());
		novoProfessor.setApelido((novoProfessor.getApelido() !=null && !novoProfessor.getApelido().isEmpty())? novoProfessor.getApelido(): professorAtual.getApelido());
		novoProfessor.setEndereco((novoProfessor.getEndereco() !=null && !novoProfessor.getEndereco().isEmpty())? novoProfessor.getEndereco(): professorAtual.getEndereco());
		novoProfessor.setCidade((novoProfessor.getCidade() !=null && !novoProfessor.getCidade().isEmpty())? novoProfessor.getCidade(): professorAtual.getCidade());
		novoProfessor.setCep((novoProfessor.getCep() !=null && !novoProfessor.getCep().isEmpty())? novoProfessor.getCep(): professorAtual.getCep());
		novoProfessor.setTelefone((novoProfessor.getTelefone() !=null && !novoProfessor.getTelefone().isEmpty())? novoProfessor.getTelefone(): professorAtual.getTelefone());
		novoProfessor.setCelular((novoProfessor.getCelular() !=null && !novoProfessor.getCelular().isEmpty())? novoProfessor.getCelular(): professorAtual.getCelular());
		novoProfessor.setEmail((novoProfessor.getEmail() !=null && !novoProfessor.getEmail().isEmpty())? novoProfessor.getEmail(): professorAtual.getEmail());
		
		//dados profissionais
		novoProfessor.setDataConclusao((novoProfessor.getDataConclusao() !=null && !novoProfessor.getDataConclusao().toString().isEmpty())? novoProfessor.getDataConclusao(): professorAtual.getDataConclusao());
		novoProfessor.setMaiorTitulacaoObtida((novoProfessor.getMaiorTitulacaoObtida() !=null && !novoProfessor.getMaiorTitulacaoObtida().isEmpty())? novoProfessor.getMaiorTitulacaoObtida(): professorAtual.getMaiorTitulacaoObtida());
		novoProfessor.setTitulacaoEmAndamento((novoProfessor.getTitulacaoEmAndamento() !=null)? novoProfessor.getTitulacaoEmAndamento(): professorAtual.getTitulacaoEmAndamento());
		novoProfessor.setNomeTitulacaoEmAndamento((novoProfessor.getNomeTitulacaoEmAndamento() !=null && !novoProfessor.getNomeTitulacaoEmAndamento().isEmpty())? novoProfessor.getNomeTitulacaoEmAndamento(): professorAtual.getNomeTitulacaoEmAndamento());
		novoProfessor.setEstimativaTerminoTitulacaoEmAndamento((novoProfessor.getEstimativaTerminoTitulacaoEmAndamento() !=null && !novoProfessor.getEstimativaTerminoTitulacaoEmAndamento().toString().isEmpty())? novoProfessor.getEstimativaTerminoTitulacaoEmAndamento(): professorAtual.getEstimativaTerminoTitulacaoEmAndamento());
		novoProfessor.setPrincipalAtuacaoProfissional((novoProfessor.getPrincipalAtuacaoProfissional() !=null && !novoProfessor.getPrincipalAtuacaoProfissional().isEmpty())? novoProfessor.getPrincipalAtuacaoProfissional(): professorAtual.getPrincipalAtuacaoProfissional());
		novoProfessor.setTempoExpProfissional((novoProfessor.getTempoExpProfissional() !=null)? novoProfessor.getTempoExpProfissional(): professorAtual.getTempoExpProfissional());
		novoProfessor.setTempoExpEmMagisterioSuperior((novoProfessor.getTempoExpEmMagisterioSuperior() !=null)? novoProfessor.getTempoExpEmMagisterioSuperior(): professorAtual.getTempoExpEmMagisterioSuperior());
		novoProfessor.setTempoExpDocenciaNaEdBasica((novoProfessor.getTempoExpDocenciaNaEdBasica() !=null)? novoProfessor.getTempoExpDocenciaNaEdBasica(): professorAtual.getTempoExpDocenciaNaEdBasica());
		novoProfessor.setUltimaAttLattes((novoProfessor.getUltimaAttLattes() !=null && !novoProfessor.getUltimaAttLattes().toString().isEmpty())? novoProfessor.getUltimaAttLattes(): professorAtual.getUltimaAttLattes());
		novoProfessor.setUrlLattes((novoProfessor.getUrlLattes() !=null && !novoProfessor.getUrlLattes().isEmpty())? novoProfessor.getUrlLattes(): professorAtual.getUrlLattes());
		novoProfessor.setUltimasPublicacoesLattes((novoProfessor.getUltimasPublicacoesLattes() !=null && !novoProfessor.getUltimasPublicacoesLattes().isEmpty())? novoProfessor.getUltimasPublicacoesLattes(): professorAtual.getUltimasPublicacoesLattes());
	}	
}
