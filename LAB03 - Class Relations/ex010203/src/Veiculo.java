public class Veiculo {
    private String placa;
    private String marca;
    private String nome;
    private String cor;

    public Veiculo (String placa, String marca, String nome, String cor) {
        this.placa = placa;
        this.marca = marca;
        this.nome = nome;
        this.cor = cor;
    }

    public String toString(){
        return "Marca do veículo: " + marca + "\nNome do veículo: " + nome + "\nPlaca do veículo: " + placa + "\nCor do veículo: " + cor + "\n";    }
}