package org.generation.blogPessoal.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;
import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.generation.blogPessoal.model.Postagem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PostagemRepositoryTest {
	
	@Autowired
	public PostagemRepository postagemRepositoryTest;

	public Postagem postagem;

	@Autowired
	private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	Validator validator = factory.getValidator();

	@BeforeEach
	public void start() {
		postagem = new Postagem("estamos fazendo teste", "os testes sempre são necessários");
		if(postagemRepositoryTest.findAllByTituloContainingIgnoreCase(postagem.getTexto()) == null) {
			postagemRepositoryTest.save(postagem);
		}
	}
	
	void findAllByTitulo() throws Exception {
		
		postagemRepositoryTest.findAllByTituloContainingIgnoreCase("os testes");
		
		List<Postagem> contatos =	postagemRepositoryTest.findAllByTituloContainingIgnoreCase("chefe");
		
		assertTrue(contatos.contains(postagem));	
	};
	
	@Test
	void testValidaAtributos() {
		Set<ConstraintViolation<Postagem>> violacao = validator.validate(postagem);
		System.out.println(violacao.toString());
		assertTrue(violacao.isEmpty());
	}
	

	@Test
	void testValidaMetodo() {
		Set<ConstraintViolation<PostagemRepository>> violacao = validator.validate(postagemRepositoryTest);
		System.out.println(violacao.toString());
		assertTrue(violacao.isEmpty());
	}


}