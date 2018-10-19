package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class UserDetailsServiceImpl /*implements UserDetailsService*/{
/*	
	@Autowired
	private UsuarioRepository repo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario user = repo.findByEmail(email);
		if(user == null) {
			throw new UsernameNotFoundException(email);
		}
		return new UserSS(user.getId(), user.getEmail(), user.getSenha(), user.getTipoUsuario());
	}*/

}
