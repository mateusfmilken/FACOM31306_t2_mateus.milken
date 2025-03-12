public class Estudante {
    private int idade;
    private String nome;

public Estudante (int idade, String nome) {
    this.idade = idade;
    this.nome = nome;
    }


public String toString(){
    return "Nome do aluno: " + nome + "\nIdade do aluno: " + idade + "\n";    }
}