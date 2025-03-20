public class Universidade {
    private String nome;
    private String dataFundacao;
    private Estudante[] estudantes;
    private int totalEstudantes;

    public Universidade(String nome, String dataFundacao) {
        this.nome = nome;
        this.dataFundacao = dataFundacao;
        this.estudantes = new Estudante[100];
        this.totalEstudantes = 0;
    }

    public void adicionarEstudante(Estudante e) {
        if (totalEstudantes < estudantes.length) {
            estudantes[totalEstudantes++] = e;
        }
    }

    public void contarEstudantes() {
        int graduacao = 0, mestrado = 0, doutorado = 0;
        for (int i = 0; i < totalEstudantes; i++) {
            if (estudantes[i] instanceof EstudanteDoutorado) {
                doutorado++;
            } else if (estudantes[i] instanceof EstudanteMestrado) {
                mestrado++;
            } else if (estudantes[i] instanceof EstudanteGraduacao) {
                graduacao++;
            }
        }
        System.out.println("Graduação: " + graduacao);
        System.out.println("Mestrado: " + mestrado);
        System.out.println("Doutorado: " + doutorado);
    }

    public void listarAlunos() {
        for (int i = 0; i < totalEstudantes; i++) {
            estudantes[i].print();
            if (estudantes[i] instanceof EstudanteDoutorado) {
                EstudanteDoutorado ed = (EstudanteDoutorado) estudantes[i];
                System.out.println("Título da Tese: " + ed.getTituloTese());
                System.out.println("Linha de Pesquisa: " + ed.getLinhaDePesquisa());
            }
            System.out.println();
        }
    }

    public void copiarPosGraduacao() {
        EstudantePosGrad[] posGraduacao = new EstudantePosGrad[totalEstudantes];
        int index = 0;
        for (int i = 0; i < totalEstudantes; i++) {
            if (estudantes[i] instanceof EstudantePosGrad) {
                posGraduacao[index++] = (EstudantePosGrad) estudantes[i];
            }
        }
        System.out.println("=== Alunos de Pós-Graduação ===");
        for (int i = 0; i < index; i++) {
            posGraduacao[i].print();
            System.out.println();
        }
    }
}