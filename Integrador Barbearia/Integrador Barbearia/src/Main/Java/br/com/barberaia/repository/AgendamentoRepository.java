package br.com.barbearia.repository;

import br.com.barbearia.entity.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    List<Agendamento> findByDataHoraBetween(LocalDateTime inicio, LocalDateTime fim);

    @Query("SELECT a FROM Agendamento a WHERE a.cliente.nome LIKE %:nome%")
    List<Agendamento> buscarPorNomeCliente(String nome);

    @Query("SELECT COUNT(a) FROM Agendamento a")
    long contarAgendamentos();

    @Query("SELECT s.nome, COUNT(a.id) FROM Agendamento a JOIN a.servico s GROUP BY s.nome")
    List<Object[]> quantidadePorServico();
}
