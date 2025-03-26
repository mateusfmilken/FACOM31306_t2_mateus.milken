class Trabalho extends Contato {
    private String tipo;

    public Trabalho(String ap, String n, String e, String aniv, String t) {
        super(ap, n, e, aniv);
        tipo = t;
    }

    @Override
    public void imprimirContato() {
        System.out.println(imprimirBasico() + ", Tipo no trabalho: " + tipo);
    }

    public String getTipo() {
        return tipo;
    }
}