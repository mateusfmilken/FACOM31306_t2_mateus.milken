public class Dono {
    private String nome;
    private int idade;
    private String cnh;
    private Veiculo[] v;

    public Dono(String nome, int idade, String cnh, Veiculo[] veiculo) {
        this.nome = nome;
        this.idade = idade;
        this.cnh = cnh;
        v = veiculo;
    }

    public String toString () {
        return "Nome do indivíduo: " + nome + "\nIdade do indivíduo: " + idade + "\nCNH:" + cnh + "\nVeículos: \n";    }
}
