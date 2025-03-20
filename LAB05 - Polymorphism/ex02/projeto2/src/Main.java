public class Main {
    public static void main(String[] args) {
        Forma[] formas = {
                new Circulo(5),
                new Quadrado(4),
                new Triangulo(3, 6),
                new Esfera(3),
                new Cubo(2),
                new Tetraedro(3)
        };

        for (Forma forma : formas) {
            System.out.println(forma.descricao());
            if (forma instanceof FormaBidimensional) {
                System.out.printf("Área: %.2f\n", ((FormaBidimensional) forma).obterArea());
            } else if (forma instanceof FormaTridimensional) {
                System.out.printf("Área: %.2f\n", ((FormaTridimensional) forma).obterArea());
                System.out.printf("Volume: %.2f\n", ((FormaTridimensional) forma).obterVolume());
            }
            System.out.println();
        }
    }
}