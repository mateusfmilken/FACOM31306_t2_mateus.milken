public class Cubo extends FormaTridimensional {
    private double lado;

    public Cubo(double lado) {
        this.lado = lado;
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    public double obterArea() {
        return 6 * lado * lado;
    }

    public double obterVolume() {
        return lado * lado * lado;
    }

    public String descricao() {
        return "Cubo de lado " + lado;
    }
}
