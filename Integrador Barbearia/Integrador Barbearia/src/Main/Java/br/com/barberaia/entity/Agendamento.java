package br.com.barbearia.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Funcionario funcionario;

    @ManyToOne
    private Servico servico;

    private LocalDateTime dataHora;

    public Agendamento() {}

    public Agendamento(Cliente cliente, Funcionario funcionario, Servico servico, LocalDateTime dataHora) {
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.servico = servico;
        this.dataHora = dataHora;
    }

    public Long getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public Servico getServico() {
        return servico;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}
