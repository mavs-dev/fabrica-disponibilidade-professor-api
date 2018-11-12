package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.dominio.Perfil;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.model.Usuario;
import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.repository.UsuarioRepository;


public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	private UsuarioRepository repo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario user = repo.findByEmail(email);
		if(user == null) {
			throw new UsernameNotFoundException("Email "+email+" não encontrado.");
		}
		Set<Perfil> perfil = new HashSet<>();
		perfil.add(user.getPerfil());
		return new UserSS(user.getId(), user.getEmail(), user.getSenha(), perfil);
	}

}
