package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.models.Professor;

public interface ProfessorRepository extends MongoRepository<Professor, String> {
	
}
