public class Estagiario extends Funcionario implements Trabalhavel {
    private int horasTrabalhadas;
    private String supervisor;

    public Estagiario(String nome, int matricula, int horasTrabalhadas, String supervisor) {
        super(nome, matricula);
        this.horasTrabalhadas = horasTrabalhadas;
        this.supervisor = supervisor;
    }

    public String getSupervisor() {
        return supervisor;
    }

    @Override
    public double calcularSalario() {
        double salarioPorHora = 10; 
        return horasTrabalhadas * salarioPorHora;
    }

    @Override
    public void trabalhar() {
        System.out.println("Estagiário trabalhando...");
    }

    @Override
    public void relatarProgresso() {
        System.out.println("Relatando progresso como estagiário...");
    }
}
