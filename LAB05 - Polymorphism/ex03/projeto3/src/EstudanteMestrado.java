public class EstudanteMestrado extends EstudantePosGrad {
    private String tipo;
    private String tituloDissertacao;

    public EstudanteMestrado(String nome, String endereco, String formacao, String linhaDePesquisa, String tipo, String tituloDissertacao) {
        super(nome, endereco, formacao, linhaDePesquisa);
        this.tipo = tipo;
        this.tituloDissertacao = tituloDissertacao;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("EstudanteMestrado{" + "tipo='" + tipo + '\'' + ", tituloDissertacao='" + tituloDissertacao + '\'' + '}');
    }

    public String getTituloDissertacao() {
        return tituloDissertacao;
    }
}