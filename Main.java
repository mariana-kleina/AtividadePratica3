import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Funcionario> funcionarios = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean sair = false;
        while (!sair) {
            System.out.println("\n1. Adicionar funcionário");
            System.out.println("2. Remover funcionário");
            System.out.println("3. Listar funcionários");
            System.out.println("4. Buscar funcionário por nome ou matricula");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    adicionarFuncionario();
                    break;
                case 2:
                    removerFuncionario();
                    break;
                case 3:
                    listarFuncionarios();
                    break;
                case 4:
                    buscarFuncionario();
                    break;
                case 5:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
        System.out.println("Programa encerrado.");
    }

    private static void adicionarFuncionario() {
        System.out.print("Digite o nome do funcionário: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a matrícula do funcionário: ");
        int matricula = scanner.nextInt();
        System.out.print("Selecione o tipo de funcionário (1 - Gerente, 2 - Desenvolvedor, 3 - Estagiário): ");
        int tipo = scanner.nextInt();
        scanner.nextLine(); 

        switch (tipo) {
            case 1:
                System.out.print("Digite o bônus anual: ");
                double bonusAnual = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Digite a equipe sob gerência: ");
                String equipe = scanner.nextLine();
                funcionarios.add(new Gerente(nome, matricula, bonusAnual, equipe));
                break;
            case 2:
                System.out.print("Digite as tecnologias que domina: ");
                String tecnologias = scanner.nextLine();
                funcionarios.add(new Desenvolvedor(nome, matricula, tecnologias));
                break;
            case 3:
                System.out.print("Digite as horas de trabalho: ");
                int horasTrabalhadas = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Digite o nome do supervisor: ");
                String supervisor = scanner.nextLine();
                funcionarios.add(new Estagiario(nome, matricula, horasTrabalhadas, supervisor));
                break;
            default:
                System.out.println("Tipo de funcionário inválido!");
        }
    }

    private static void removerFuncionario() {
        System.out.print("Digite a matrícula do funcionário a ser removido: ");
        int matricula = scanner.nextInt();
        scanner.nextLine(); 

        funcionarios.removeIf(funcionario -> funcionario.getMatricula() == matricula);
        System.out.println("Funcionário removido com sucesso.");
    }

    private static void listarFuncionarios() {
        System.out.println("\nLista de Funcionários:");
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario.getNome() + " - " + funcionario.getClass().getSimpleName());
        }
    }

    private static void buscarFuncionario() {
        System.out.print("Digite o nome ou matrícula do funcionário: ");
        String busca = scanner.nextLine();

        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNome().equalsIgnoreCase(busca) || Integer.toString(funcionario.getMatricula()).equals(busca)) {
                System.out.println("Funcionário encontrado:");
                System.out.println(funcionario.getNome() + " - " + funcionario.getClass().getSimpleName());
                return;
            }
        }
        System.out.println("Funcionário não encontrado.");
    }
}
