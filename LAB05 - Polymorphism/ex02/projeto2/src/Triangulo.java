public class Triangulo extends FormaBidimensional {
    private double base, altura;

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double obterArea() {
        return (base * altura) / 2;
    }

    public String descricao() {
        return "Triângulo de base " + base + " e altura " + altura;
    }
}