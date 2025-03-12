public class C2 extends C1 {
        public int publ2;
        private int priv2;
        protected int prot2;

        public C2 (int publ2, int priv2, int prot2, int publ1, int priv1, int prot1)  {
            super(publ1, priv1, prot1);
            this.publ2 = publ2;
            this.priv2 = priv2;
            this.prot2 = prot2;
            System.out.println("Classe C2: chamada do construtor com parâmetros.");
        }

        public C2() {
            System.out.println("Classe C2: chamada do construtor padrão, sem parâmetros.");
        }

        public int getPriv2 () {
            return priv2;
        }

        public void mostrar_atributos(){
            System.out.println("C1 - Público: " + publ1 + "\nC1 - Privado: " + getPriv1() + "\nC1 - Protegido: " + prot1 + "\nC2 - Público: " + publ2 + "\nC2 - Privado: " + priv2 + "\nC2 - Protegido: " + prot2);
            }

        public void mostrar_atributos_super(){
            System.out.println("Mostrar atributos com super:\n");
            super.mostrar_atributos();
            System.out.println("C2 - Público: " + publ2 + "\nC2 - Privado: " + priv2 + "\nC2 - Protegido: " + prot2);
        }
}


