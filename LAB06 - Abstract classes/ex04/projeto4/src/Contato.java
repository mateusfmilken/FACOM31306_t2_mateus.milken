public abstract class Contato {
    protected String apelido, nome, email, aniversario;

    public Contato(String ap, String n, String e, String aniv) {
        apelido = ap;
        nome = n;
        email = e;
        aniversario = aniv;
    }

    public String imprimirBasico() {
        return "Apelido: " + apelido + ", Nome: " + nome + ", Email: " + email + ", Aniversário: " + aniversario;
    }

    public abstract void imprimirContato();
}