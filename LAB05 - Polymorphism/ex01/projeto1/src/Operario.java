public class Operario extends Funcionario {
    public double valorProd;
    public double qtdProd;
    public double salario;

    public Operario (String nome, String dataNasc, double valorProd, double qtdProd) {
        super(nome, dataNasc);
        this.valorProd = valorProd;
        this.qtdProd = qtdProd;
        this.salario = valorProd * qtdProd;
    }

    public double getSalario() {
        return salario;
    }
}