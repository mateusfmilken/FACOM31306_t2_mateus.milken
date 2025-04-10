public class Produto implements Classificavel {
    private int codigo ;

    public Produto (int codigo) {
        this.codigo = codigo;
    }

    int getCodigo(){
        return codigo;
    }

    public int eMenorQue (Classificavel o) {
        Produto compara = ( Produto ) o;
        if (this.codigo < compara.getCodigo()) {
            return 1;
        } else return 0;
        }

    public String toString() {
        return "Código: " + this.codigo ;
    }
}

