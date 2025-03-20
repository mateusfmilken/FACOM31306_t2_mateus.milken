public class Chefe extends Funcionario {
    double salario;

    public Chefe(String nome, String dataNascimento, double salario) {
        super(nome, dataNascimento);
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

}