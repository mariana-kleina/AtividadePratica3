public class Gerente extends Funcionario implements Trabalhavel {
    private double bonusAnual;
    private String equipe;

    public Gerente(String nome, int matricula, double bonusAnual, String equipe) {
        super(nome, matricula);
        this.bonusAnual = bonusAnual;
        this.equipe = equipe;
    }

    public String getEquipe() {
        return equipe;
    }

    @Override
    public double calcularSalario() {
        return 5000 + bonusAnual; 
    }

    @Override
    public void trabalhar() {
        System.out.println("Gerente trabalhando...");
    }

    @Override
    public void relatarProgresso() {
        System.out.println("Relatando progresso como gerente...");
    }
}
