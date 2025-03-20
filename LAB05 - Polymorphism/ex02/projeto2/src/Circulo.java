public class Circulo extends FormaBidimensional {
    private double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    public double obterArea() {
        return Math.PI * raio * raio;
    }

    public String descricao() {
        return "Círculo de raio " + raio;
    }
}