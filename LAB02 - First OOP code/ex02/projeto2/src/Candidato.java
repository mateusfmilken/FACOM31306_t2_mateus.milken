public class Candidato {
    private String nomeC;
    private String dataNasc;
    private String genero;
    private double bens;
    private boolean reeleicao;
    private int numeroPartido;
    private String cargo;

    public void setNomeC(String nomeC) {
        this.nomeC = nomeC;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setBens(double bens) {
        this.bens = bens;
    }

    public void setReeleicao(boolean reeleicao) {
        this.reeleicao = reeleicao;
    }

    public void setNumeroPartido(int numeroPartido) {
        this.numeroPartido = numeroPartido;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
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

    public boolean isReeleicao() {
        return reeleicao;
    }

    public int getNumeroPartido() {
        return numeroPartido;
    }

    public String getCargo() {
        return cargo;
    }

    public void atualizarNome(String novoNome) {
        this.nomeC = novoNome;
    }

    public void atualizarBens(double novoValorBens) {
        this.bens = novoValorBens;
    }

    public void atualizarReeleicao(boolean novaReeleicao) {
        this.reeleicao = novaReeleicao;
    }

    public void atualizarCargo(String novoCargo) {
        this.cargo = novoCargo;
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
