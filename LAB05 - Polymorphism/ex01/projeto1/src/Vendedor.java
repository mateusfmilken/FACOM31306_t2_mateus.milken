public class Vendedor extends Funcionario {
    public double valorFixo;
    public double comissao;
    public int vendas;
    public double salario;

    public Vendedor (String nome, String dataNascimento, double valorFixo, double comissao, int vendas) {
        super(nome, dataNascimento);
        this.valorFixo = valorFixo;
        this.comissao = comissao;
        this.vendas = vendas;
        this.salario = valorFixo + (comissao * vendas);
    }

    public double getSalario() {
        return salario;
    }


}