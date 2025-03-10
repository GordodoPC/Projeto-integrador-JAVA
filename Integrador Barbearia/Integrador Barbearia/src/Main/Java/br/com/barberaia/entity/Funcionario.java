package br.com.barbearia.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Funcionario extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cargo;

    @ElementCollection
    private List<String> horariosDisponiveis;

    public Funcionario() {}

    public Funcionario(String nome, String telefone, String email, String cargo, List<String> horarios) {
        super(nome, telefone, email);
        this.cargo = cargo;
        this.horariosDisponiveis = horarios;
    }

    public Long getId() {
        return id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public List<String> getHorariosDisponiveis() {
        return horariosDisponiveis;
    }

    public void setHorariosDisponiveis(List<String> horariosDisponiveis) {
        this.horariosDisponiveis = horariosDisponiveis;
    }
}
