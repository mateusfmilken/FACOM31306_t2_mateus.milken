public class Produto implements Classificavel {
    private int codigo ;

    public Produto (int codigo) {
        this.codigo = codigo;
    }

    int getCodigo(){
        return codigo;
    }

    public boolean eMenorQue (Classificavel o) {
        Produto compara = ( Produto ) o;
        if (this.codigo < compara.getCodigo()) {
            return true; }
        else return false; }

    public String toString() {
        return "Código: " + this.codigo ;
    }
}