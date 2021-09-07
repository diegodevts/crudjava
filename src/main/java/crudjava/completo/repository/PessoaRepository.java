package crudjava.completo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import crudjava.completo.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	
}
