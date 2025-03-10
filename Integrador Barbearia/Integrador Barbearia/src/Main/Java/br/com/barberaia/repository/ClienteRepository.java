package br.com.barbearia.repository;

import br.com.barbearia.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findByNomeContainingIgnoreCase(String nome);

    @Query("SELECT COUNT(c) FROM Cliente c")
    long contarClientes();
}
s