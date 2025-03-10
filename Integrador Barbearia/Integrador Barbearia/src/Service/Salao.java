package Service;

import Model.*;
import java.util.*;

public class Salao {
    private ArrayList<Agendamento> agendamentos = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void menu() {
        while (true) {
            System.out.println("\n--- Sistema de Agendamento ---");
            System.out.println("1. Agendar Servico");
            System.out.println("2. Listar Agendamentos");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opcao: ");

            try {
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao) {
                    case 1 -> agendarServico();
                    case 2 -> listarAgendamentos();
                    case 3 -> {
                        System.out.println("Encerrando sistema...");
                        return;
                    }
                    default -> System.out.println("Opcao invalida!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida. Digite um numero.");
            }
        }
    }

    private void agendarServico() {
        try {
            System.out.print("Nome do Cliente: ");
            String nome = scanner.nextLine();
            System.out.print("Telefone: ");
            String telefone = scanner.nextLine();
            Cliente cliente = new Cliente(nome, telefone);

            System.out.println("Servicos disponiveis: ");
            for (Servico s : Servico.values()) {
                System.out.println(s.ordinal() + 1 + ". " + s);
            }
            System.out.print("Escolha um servico: ");
            int escolha = Integer.parseInt(scanner.nextLine());

            if (escolha < 1 || escolha > Servico.values().length) {
                System.out.println("Servico invalido!");
                return;
            }
            Servico servico = Servico.values()[escolha - 1];

            System.out.print("Data do Agendamento (dd/mm/aaaa): ");
            String data = scanner.nextLine();

            Agendamento agendamento = new Agendamento(cliente, servico, data);
            agendamentos.add(agendamento);
            agendamento.agendar();

        } catch (Exception e) {
            System.out.println("Erro ao agendar: " + e.getMessage());
        }
    }

    private void listarAgendamentos() {
        if (agendamentos.isEmpty()) {
            System.out.println("Nenhum agendamento cadastrado!");
        } else {
            System.out.println("\n--- Lista de Agendamentos ---");
            for (Agendamento a : agendamentos) {
                System.out.println(a.getInfo());
            }
        }
    }
}