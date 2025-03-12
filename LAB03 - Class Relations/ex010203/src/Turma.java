public class Turma {
    private String serie;
    private int quantidadeA;
    private Estudante[] aluno;

    public Turma (String serie, int quantidadeA, Estudante[] estudante) {
    this.serie = serie;
    this.quantidadeA = quantidadeA;
    aluno = estudante;
    }

    public String toString(){
        return "Turma: " + serie + "\nQuantidade de alunos: " + quantidadeA + "\nAlunos: " + "\n";    }
}

