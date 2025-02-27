public class Candidato {
    private String nomeC;
    private String dataNasc;
    private String genero;
    private double bens;
    private boolean reeleicao;
    private int numeroPartido;
    private String cargo;

    public void setNomeC(String nomec) {
        nomeC = nomec;
    }

    public void setDataNasc(String datanasc) {
        dataNasc = datanasc;
    }

    public void setGenero(String Genero) {
        genero = Genero;
    }

    public void setBens(double Bens) {
        bens = Bens;
    }

    public void setReeleicao(boolean Reeleicao) {
        reeleicao = Reeleicao;
    }

    public void setNumeroPartido(int numeropartido) {
        numeroPartido = numeropartido;
    }

    public void setCargo(String Cargo) {
        cargo = Cargo;
    }

    public String getNomeC() {
        return nomeC;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public String getGenero() {
        return genero;
    }

    public double getBens() {
        return bens;
    }

    public boolean vaiReeleicao() {
        return reeleicao;
    }

    public int getNumeroPartido() {
        return numeroPartido;
    }

    public String getCargo() {
        return cargo;
    }

    public void exibirInfo() {
        System.out.println("\n-----------------------------");
        System.out.println("Nome: " + nomeC);
        System.out.println("Data de nascimento: " + dataNasc);
        System.out.println("Gênero da pessoa: " + genero);
        System.out.println("Valor em bens: R$" + bens);
        System.out.println("Candidato à Reeleição: " + (reeleicao ? "Sim" : "Não"));
        System.out.println("Número do partido: " + numeroPartido);
        System.out.println("Cargo pretendido: " + cargo);
        System.out.println("\n-----------------------------");
    }
}