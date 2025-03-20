public class EstudanteGraduacao extends Estudante {
    private String tituloTCC;

    public EstudanteGraduacao(String nome, String endereco, String tituloTCC) {
        super(nome, endereco);
        this.tituloTCC = tituloTCC;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("EstudanteGraduacao{" + "tituloTCC='" + tituloTCC + '\'' + '}');
    }

    public String getTituloTCC() {
        return tituloTCC;
    }
}