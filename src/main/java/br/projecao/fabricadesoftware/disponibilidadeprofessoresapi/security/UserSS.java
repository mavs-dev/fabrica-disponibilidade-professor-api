package br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.projecao.fabricadesoftware.disponibilidadeprofessoresapi.dominio.Perfil;

public class UserSS implements UserDetails{
	private static final long serialVersionUID = -4252743386861191029L;

	private Long id;
	private String email;
	private String senha;
	private Collection<? extends GrantedAuthority> authorities;
	
	public UserSS() {
	}

	public UserSS(Long id, String email, String senha, Set<Perfil> nivelAcesso) {
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.authorities = nivelAcesso.stream().map(x -> new SimpleGrantedAuthority(x.getRole())).collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return senha;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
