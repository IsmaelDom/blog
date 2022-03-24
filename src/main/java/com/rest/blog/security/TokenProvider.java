package com.rest.blog.security;

import com.rest.blog.model.Rol;
import io.jsonwebtoken.*;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class TokenProvider extends JWTAuthorizationFilter {
	
	public TokenProvider(AuthenticationManager authenticationManager) {
	}

	protected final static String SECRET = "Blog_API";

	public static String generateToken(String usuario, List<Rol> idRol, long idUsuario, Integer tiempoToken) {
		
		final Integer segundos = tiempoToken;
		List<String> roles = idRol.stream()
				.map(item -> item.getNombre())
				.collect(Collectors.toList());
		/*final String authorities = idRol.stream()
				.map(GrantedAuthority::getAuthority)
				.collect(Collectors.joining(","));*/

		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN");
		String token = Jwts.builder().setId("BlogJWT").setSubject(usuario)
				.claim("authorities",
						grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.claim("role", roles)
				.claim("usuario", idUsuario).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + segundos))
				.signWith(SignatureAlgorithm.HS512, SECRET.getBytes()).compact();

		return "Bearer " + token;
	}

}
