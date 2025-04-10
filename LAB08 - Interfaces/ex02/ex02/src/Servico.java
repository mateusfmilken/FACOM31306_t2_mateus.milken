public class Servico implements Classificavel {
    private double preco;

    public Servico(double preco) {
        this.preco = preco;
    }

    double getPreco(){
        return preco;
    }

    public int eMenorQue(Classificavel o) {
        Servico compara = (Servico) o;
        if (this.preco < compara.getPreco()) {
            return 1;
        } else return 0;
        }

    public String toString() {
        return "Preço: " + this.preco;
    }
}