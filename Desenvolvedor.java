public class Desenvolvedor extends Funcionario implements Trabalhavel {
    private String tecnologias;

    public Desenvolvedor(String nome, int matricula, String tecnologias) {
        super(nome, matricula);
        this.tecnologias = tecnologias;
    }

    @Override
    public double calcularSalario() {
   
        int bonusPorTecnologia = 500; 
        int numeroTecnologias = tecnologias.split(",").length;
        return 2000 + (numeroTecnologias * bonusPorTecnologia);
    }

    @Override
    public void trabalhar() {
        System.out.println("Desenvolvedor trabalhando...");
    }

    @Override
    public void relatarProgresso() {
        System.out.println("Relatando progresso como desenvolvedor...");
    }
}
