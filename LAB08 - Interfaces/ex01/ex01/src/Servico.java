public class Servico implements Classificavel {
    private double preco;

    public Servico(double preco) {
        this.preco = preco;
    }

    double getPreco(){
        return preco;
    }

    public boolean eMenorQue(Classificavel o) {
        Servico compara = (Servico) o;
        if (this.preco < compara.getPreco()) {
            return true; }
        else return false; }


    public String toString() {
        return "Preço: " + this.preco;
    }
}