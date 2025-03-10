package br.com.barbearia.repository;

import br.com.barbearia.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Long> {}
