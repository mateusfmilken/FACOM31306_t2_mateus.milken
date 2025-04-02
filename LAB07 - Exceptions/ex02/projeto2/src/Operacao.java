public class Operacao {
    private int numerador;
    private int denominador;

    public Operacao (int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public Operacao(){
    }

    public void iniciarOperacao(int numerador, int denominador) {
        try {
            int resultado = calcular(numerador, denominador);
            System.out.println("Resultado: " + resultado);
        } catch (DivisaoPorZeroException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public int calcular(int numerador, int denominador) throws DivisaoPorZeroException {
        return dividir(numerador, denominador);
    }

    public int dividir(int numerador, int denominador) throws DivisaoPorZeroException {
        if (denominador == 0) {
            throw new DivisaoPorZeroException("Não é possível dividir por zero.");
        }
        return numerador / denominador;
    }
}