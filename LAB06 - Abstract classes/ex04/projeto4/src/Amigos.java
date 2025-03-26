public class Amigos extends Contato {
    private int grau; // 1 - melhor amigo, 2 - amigo, 3 - conhecido

    public Amigos(String ap, String n, String e, String aniv, int g) {
        super(ap, n, e, aniv);
        grau = g;
    }

    @Override
    public void imprimirContato() {
        System.out.println(imprimirBasico() + ", Grau de amizade: " + grau);
    }

    public int getGrau() {
        return grau;
    }
}