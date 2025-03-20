public class Quadrado extends FormaBidimensional {
    private double lado;

    public Quadrado(double lado) {
        this.lado = lado;
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    public double obterArea() {
        return lado * lado;
    }

    public String descricao() {
        return "Quadrado de lado " + lado;
    }
}