package crudjava.completo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import crudjava.completo.model.Pessoa;
import crudjava.completo.services.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
	
	
	@Autowired
	PessoaService repository;
	
	
	@PostMapping("/cadastro")
	public Pessoa addPessoa(@RequestBody Pessoa pessoa) {
		return repository.addPessoa(pessoa);
	}
	
	@GetMapping
	public List<Pessoa> listarPessoas(){
		return repository.listarPessoas();
	}
	
	@GetMapping(path = "/{id}")
	public Pessoa listarPessoa(@PathVariable Long id) {
		 return repository.listarPessoa(id);
	}
	
	@PutMapping(path = "/{id}")
	public Pessoa editarPessoa(@RequestBody Pessoa pessoa){
		return repository.editarPessoa(pessoa);
	}
	
	@DeleteMapping(path = "/{id}")
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	public void deletarPessoas(@PathVariable Long id) {
		repository.deletarPessoas(id);
		
	}
}
