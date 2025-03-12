public class C3 extends C2 {
        public int publ3;
        private int priv3;
        protected int prot3;

        public C3 (int publ3, int priv3, int prot3) {
            this.publ3 = publ3;
            this.priv3 = priv3;
            this.prot3 = prot3;
                System.out.println("Classe C3: chamada do construtor com parâmetros");
        }
        public C3() {
                System.out.println("Classe C3: chamada do construtor padrão, sem parâmetros.");
        }
        public C3(int publ3, int priv3, int d3, int publ2, int priv2, int prot2, int publ1, int priv1, int prot1) {
            super(publ2, priv2, prot2, publ1, priv1, prot1);
            this.publ3 = publ3;
            this.priv3 = priv3;
            this.prot3 = d3;
        }
        public void mostrar_atributos() {
            System.out.println("\nC1 - Público: " + publ1 + "\nC1 - Privado: " + getPriv1() + "\nC1 - Protegido: " + prot1 + "\nC2 - Público: " + publ2 + "\nC2 - Privado: " + getPriv2() + "\nC2 - Protegido: " + prot2 + "\nC3 - Público: " + publ3 + "\nC3 - Privado: " + priv3 + "\nC3 - Protegido: " + prot3);
        }
        public void mostrar_atributos_super(){
            System.out.println("\nMostrar atributos com super:\n");
            super.mostrar_atributos();
            System.out.println("C3 - Público: " + publ3 + "\nC3 - Privado: " + priv3 + "\nC3 - Protegido: " + prot3);
        }
}