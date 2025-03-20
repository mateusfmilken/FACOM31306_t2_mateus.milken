public class EstudantePosGrad extends Estudante {
    private String formacao;
    private String linhaDePesquisa;

    public EstudantePosGrad(String nome, String endereco, String formacao, String linhaDePesquisa) {
        super(nome, endereco);
        this.formacao = formacao;
        this.linhaDePesquisa = linhaDePesquisa;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("EstudantePosGrad{" + "formacao='" + formacao + '\'' +
                ", linhaDePesquisa='" + linhaDePesquisa + '\'' + '}');
    }

    public String getFormacao() {
        return formacao;
    }

    public String getLinhaDePesquisa() {
        return linhaDePesquisa;
    }
}