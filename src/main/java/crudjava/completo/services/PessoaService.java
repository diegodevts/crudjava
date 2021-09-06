package crudjava.completo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import crudjava.completo.model.Pessoa;
import crudjava.completo.repository.PessoaRepository;


@Service
public class PessoaService {
	
	@Autowired
	PessoaRepository repository;
	
	@PostMapping("/cadastro")
	public Pessoa addPessoa(@RequestBody Pessoa pessoa) {
		return repository.save(pessoa);
	}
	
	@GetMapping
	public List<Pessoa> listarPessoas(){
		return repository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	public Pessoa listarPessoa(@PathVariable Long id) {
		 return repository.findById(id).get();
	}
	
	@PutMapping(path = "/{id}")
	public Pessoa editarPessoa(@RequestBody Pessoa pessoa){
		return repository.save(pessoa);
	}
	
	@DeleteMapping(path = "/{id}")
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	public void deletarPessoas(@PathVariable Long id) {
		repository.deleteById(id);
		
	}
}
