public class Departamento {
    private String funcao;
    private int qtdfuncionarios;


public Departamento (String funcao, int qtdfuncionarios) {
    this.funcao = funcao;
    this.qtdfuncionarios = qtdfuncionarios;
}

    public String toString(){
        return "Funcao do departamento: " + funcao + "\nQuantidade de funcionarios: " + qtdfuncionarios + "\n";    }
}

