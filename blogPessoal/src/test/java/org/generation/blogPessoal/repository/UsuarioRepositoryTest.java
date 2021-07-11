package org.generation.blogPessoal.repository;


import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.generation.blogPessoal.model.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class UsuarioRepositoryTest {
	
	public Usuario usuario;
	
	public UsuarioRepository repositoryUsuario;

	@Autowired
	private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	Validator validator = factory.getValidator();
	
	@Test
	public void start() {

		usuario = new Usuario("Joel", "2345678", "joel@gmail.com");
		if(repositoryUsuario.findByEmail(usuario.getEmail()) != null) {
			repositoryUsuario.save(usuario);
		}

	};


}