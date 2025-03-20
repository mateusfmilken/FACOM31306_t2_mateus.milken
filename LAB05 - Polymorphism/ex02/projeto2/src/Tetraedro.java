public class Tetraedro extends FormaTridimensional {
    private double lado;

    public Tetraedro(double lado) {
        this.lado = lado;
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    public double obterArea() {
        return Math.sqrt(3) * lado * lado;
    }

    public double obterVolume() {
        return (Math.pow(lado, 3)) / (6 * Math.sqrt(2));
    }

    public String descricao() {
        return "Tetraedro de lado " + lado;
    }
}