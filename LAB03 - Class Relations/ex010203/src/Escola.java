public class Escola {
    private String nomeE;
    private String cidade;
    private Departamento[] departamentos;

public Escola (String nomeE, String cidade, Departamento[] dep) {
    this.nomeE = nomeE;
    this.cidade = cidade;
    departamentos = dep;
}

    public String toString(){
        return "Nome da escola: " + nomeE + "\nCidade: " + cidade + "\nDepartamentos: " + "\n";    }
}
