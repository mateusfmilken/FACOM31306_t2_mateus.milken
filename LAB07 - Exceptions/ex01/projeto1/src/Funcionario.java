public class Funcionario {
    private String nome;
    private String CPF;
    private double salario;
    private double tetoSalarial;

    public Funcionario (String nome, String CPF, double salario, double tetoSalarial){
        this.nome = nome;
        this.CPF = CPF;
        this.salario = salario;
        this.tetoSalarial = tetoSalarial;
    }

    public Funcionario (){
    }

    public double aumentaSalario(double porcentagem) {
        if (this.salario + (this.salario * porcentagem/100) > tetoSalarial) {
            throw new IllegalArgumentException("Erro: Valor ultrapassa o teto!");
        } else if (this.salario + (this.salario * porcentagem/100) < 0) {
            throw new IllegalArgumentException("Erro: Valor inválido de salário!");
        } else {
            this.salario += (this.salario * porcentagem/100);
        }
        return this.salario;
    }

    public String toString(){
        return "Nome do indivíduo: " + nome + "\nCPF do indivíduo: " + CPF + "\nSalário inicial do indivíduo: " + salario + "\nTeto salarial do indivíduo: " + tetoSalarial;
    }
}