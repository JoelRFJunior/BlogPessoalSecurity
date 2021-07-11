package org.generation.blogPessoal.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class PostagemTest {

	public Postagem postegem;

	@Autowired
	private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	Validator validator = factory.getValidator();

	@BeforeEach
	public void start() {
		postegem = new Postagem("porque fazer os testes?", "todo teste é necessário para que uma aplicação seja considerada correta");
	}

	@Test
	void testValidaAtributos() {
		Set<ConstraintViolation<Postagem>> violacao = validator.validate(postegem);
		System.out.println(violacao.toString());
		assertTrue(violacao.isEmpty());
	}

}