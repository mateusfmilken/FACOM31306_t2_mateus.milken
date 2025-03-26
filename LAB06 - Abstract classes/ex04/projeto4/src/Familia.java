public class Familia extends Contato {
    private String parentesco;

    public Familia(String ap, String n, String e, String aniv, String par) {
        super(ap, n, e, aniv);
        parentesco = par;
    }

    @Override
    public void imprimirContato() {
        System.out.println(imprimirBasico() + ", Parentesco: " + parentesco);
    }

    public String getParentesco() {
        return parentesco;
    }
}