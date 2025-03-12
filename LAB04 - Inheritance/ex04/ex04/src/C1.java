public class C1 {
        public int publ1;
        private int priv1;
        protected int prot1;

        public C1 (int publ1, int priv1, int prot1) {
            this.publ1 = publ1;
            this.priv1 = priv1;
            this.prot1 = prot1;
                System.out.println("Classe C1: chamada do construtor com parâmetros.");
        }
        public C1() {
                System.out.println("Classe C1: chamada do construtor padrão, sem parâmetros.");
        }

        public int getPriv1() {
            return priv1;
        }

        public void mostrar_atributos() {
            System.out.println("C1 - Público: " + publ1 + "\nC1 - Privado: " + priv1 + "\nC1 - Protegido: " + prot1);
    }
}
