public class Dueto {
    private String nome;
    private Musico titular1;
    private Musico titular2;
    private Musico substituto;

    public Dueto(String nomeTime, Musico titular1, Musico titular2, Musico substituto) {
        nome = nomeTime;
        this.titular1 = titular1;
        this.titular2 = titular2;
        this.substituto = substituto;
    }

    public Dueto(String nomeTime, Musico titular1, Musico titular2) {
        this.nome = nomeTime;
        this.titular1 = titular1;
        this.titular2 = titular2;
        this.substituto = null;
    }

    public double calcularRemuneracao() {
        int somaRemuneracao = titular1.getRemuneracao() + titular2.getRemuneracao();
        int qtdJogadores = 2;
        if (substituto != null) {
            somaRemuneracao += substituto.getRemuneracao();
            qtdJogadores++;
        }
        return (double) somaRemuneracao / qtdJogadores;
    }

    @Override
    public String toString() {
        String info = "Dueto: " + nome + "\nTitulares:\n" + titular1 + "\n" + titular2;
        if (substituto != null) {
            info += "\nSubstituto:\n" + substituto;
        }
        info += "\nRemuneracao media(reais/hora): " + calcularRemuneracao();
        return info;
    }
}