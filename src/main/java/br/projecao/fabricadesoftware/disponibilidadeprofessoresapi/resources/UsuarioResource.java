package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.model.Usuario;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.repository.UsuarioRepository;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.resources.interfaces.Resource;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.util.CriptografiaUtil;

@RestController
@RequestMapping(value = "/usuario", produces = MediaType.APPLICATION_JSON_VALUE)
public class UsuarioResource implements Resource<Usuario> {

	@Autowired
	private UsuarioRepository repository;

	@Override
	public void fillInBlankFields(Usuario entity) {

	}

	@Override
	public void merge(Usuario newEntity, Usuario oldEntity) {

	}

	@Override
	public JpaRepository<Usuario, Long> getRepository() {
		return this.repository;
	}

	@Override
	public void executaAntesDeCadastrar(Usuario entity) {
		entity.setSenha(CriptografiaUtil.getHash(entity.getSenha()));
		entity.setDataHoraCadastro(LocalDateTime.now());
	}

	@Override
	public void executaAntesDeAtualizarParcialMente(Long id, Usuario entity) {
		entity.setId(id);
		entity.setDataHoraAlteracao(LocalDateTime.now());
		fillInBlankFields(entity);
	}

	@Override
	public void executaAntesDeAtualizarTotalmente(Long id, Usuario entity) {
		entity.setId(id);
		entity.setDataHoraAlteracao(LocalDateTime.now());
	}

	@Override
	public void executaAntesDeDeletar(Long id) {
		
	}

	@Override
	public boolean isInvalidoParaAtualizacao(Long id, Usuario entity) {
		return entity.getId() == null || entity.getId().longValue() <= 0;
	}
}
