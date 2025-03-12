public class Vendedor extends Funcionario {
    public double valorFixo;
    public double comissao;
    public int vendas;

    public Vendedor (String nome, String dataNascimento, double valorFixo, double comissao, int vendas) {
        super(nome, dataNascimento);
        this.valorFixo = valorFixo;
        this.comissao = comissao;
        this.vendas = vendas;
    }

    public double calculaSalarioVendedor(){
        double salarioV = valorFixo + (comissao * vendas);
        return salarioV;
    }


}
