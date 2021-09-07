package crudjava.completo.services.test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import crudjava.completo.model.Pessoa;
import crudjava.completo.repository.PessoaRepository;
import crudjava.completo.services.PessoaService;


@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class PessoaServiceTest {
	
	@Autowired
	PessoaService pessoaService;
	
	@Autowired
	PessoaRepository pessoas;
	
	@Test
	@Before
	public void addPessoaTest() {
		Pessoa pessoaTest = new Pessoa(null, "adadad", 13, "adadad");
		Pessoa pessoa = pessoaService.addPessoa(pessoaTest);
		assertEquals(13, pessoa.getIdade());
	}
	
	@Test
	@After
	public void deletarPessoasTest() {
		
		pessoaService.deletarPessoas(32L);
		Optional<Pessoa> optionalPessoa = pessoas.findById(32L);
		assertFalse(optionalPessoa.isPresent());
	}
	
	
}
