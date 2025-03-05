import java.util.ArrayList;
import java.util.Scanner;

// Enum para serviços disponíveis
enum Servico {
    CORTE, BARBA, SOBRANCELHA;
}

// Classe base para Pessoa
class Pessoa {
    protected String nome;
    protected String telefone;

    public Pessoa(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() { return nome; }
    public String getTelefone() { return telefone; }
}

// Cliente herda de Pessoa
class Cliente extends Pessoa {
    public Cliente(String nome, String telefone) {
        super(nome, telefone);
    }
}

// Interface para Agendamento
interface Agendavel {
    void agendar();
}

// Classe Agendamento
class Agendamento implements Agendavel {
    private Cliente cliente;
    private Servico servico;
    private String data;

    public Agendamento(Cliente cliente, Servico servico, String data) {
        this.cliente = cliente;
        this.servico = servico;
        this.data = data;
    }

    @Override
    public void agendar() {
        System.out.println("Agendamento realizado para " + cliente.getNome() + " - " + servico + " em " + data);
    }

    public String getInfo() {
        return "Cliente: " + cliente.getNome() + " | Servico: " + servico + " | Data: " + data;
    }
}

// Classe para gerenciar o sistema
class Salao {
    private ArrayList<Agendamento> agendamentos = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void menu() {
        while (true) {
            System.out.println("\n--- Sistema de Agendamento ---");
            System.out.println("1. Agendar Servico");
            System.out.println("2. Listar Agendamentos");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opcao: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir quebra de linha
            
            switch (opcao) {
                case 1:
                    agendarServico();
                    break;
                case 2:
                    listarAgendamentos();
                    break;
                case 3:
                    System.out.println("Encerrando sistema...");
                    return;
                default:
                    System.out.println("Opcao invalida!");
            }
        }
    }

    private void agendarServico() {
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
        int escolha = scanner.nextInt();
        scanner.nextLine(); // Consumir quebra de linha
        
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

// Classe principal
public class Main {  
    public static void main(String[] args) {
        Salao salao = new Salao();
        salao.menu();
    }
}
