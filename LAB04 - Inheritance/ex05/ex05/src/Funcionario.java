public class Funcionario {
    private String nome;
    private String dataNasc;
    private double salario;

    public Funcionario(String nome, String dataNasc){
        this.nome = nome;
        this.dataNasc = dataNasc;
    }
    public double getSalario() {
        return salario;
    }
}
