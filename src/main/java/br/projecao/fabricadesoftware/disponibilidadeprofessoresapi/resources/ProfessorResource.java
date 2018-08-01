package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.models.Professor;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.repository.ProfessorRepository;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/professor")
public class ProfessorResource {
	
	@Autowired
	private ProfessorRepository pr;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Iterable<Professor> listaProfessores() {
		Iterable<Professor> listaProfessores = pr.findAll();
		return listaProfessores;
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value ="/{id}")
	public @ResponseBody Iterable<Professor> listaProfessores(@PathVariable("id") String id) {
		Iterable<Professor> listaProfessores = pr.findAll();
		return listaProfessores;
	}
	
	@PostMapping()
	public Professor cadastrarProfessor(@RequestBody @Valid Professor professor) {
		return pr.save(professor);
	}
	
	@DeleteMapping()
	public Professor deletarProfessor(@RequestBody Professor professor) {
		pr.delete(professor);
		return professor;
	}
}
