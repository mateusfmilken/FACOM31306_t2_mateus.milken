public class Operario extends Funcionario {
    public double valorProd;
    public double qtdProd;

    public Operario (String nome, String dataNasc, double valorProd, double qtdProd) {
        super(nome, dataNasc);
        this.valorProd = valorProd;
        this.qtdProd = qtdProd;
    }

    public double calculaSalarioOperario(){
        double salarioO = valorProd * qtdProd;
        return salarioO;
    }
}
