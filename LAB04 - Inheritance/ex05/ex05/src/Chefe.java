public class Chefe extends Funcionario {
    double salarioFixo;

    public Chefe(String nome, String dataNascimento, double salarioFixo) {
        super(nome, dataNascimento);
        this.salarioFixo = salarioFixo;
    }

    public double calculaSalarioChefe() {
        return salarioFixo;
    }

}

