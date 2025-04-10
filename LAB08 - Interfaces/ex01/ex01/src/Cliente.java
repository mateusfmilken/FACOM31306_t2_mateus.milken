public class Cliente implements Classificavel {
    private String nome;

    public Cliente(String nome) {
        this.nome = nome;
    }

    String getNome(){
        return nome;
    }

    public boolean eMenorQue(Classificavel o) {
        Cliente compara = (Cliente) o;
        if (this.nome.compareTo(compara.getNome()) < 0){
            return true; }
        else return false; }

    public String toString() {
        return "Nome: " + this.nome ;
    }
}