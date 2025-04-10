public class Cliente implements Classificavel {
    private String nome;

    public Cliente(String nome) {
        this.nome = nome;
    }

    String getNome(){
        return nome;
    }

    public int eMenorQue(Classificavel o) {
        Cliente compara = (Cliente) o;
        if (this.nome.compareTo(compara.getNome()) < 0){
            return 1;
        } else return 0;
        }

    public String toString() {
        return "Nome: " + this.nome ;
    }
}