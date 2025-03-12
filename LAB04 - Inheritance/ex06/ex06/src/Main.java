public class Main {
    public static void main(String[] args) {
        Ingresso ingressoNormal = new Normal(50);
        ingressoNormal.escreveValor();
        ((Normal) ingressoNormal).tipoIngresso();

        VIP ingressoVIP = new VIP(50, 30);
        System.out.println("Valor do ingresso VIP: R$" + ingressoVIP.getValorVIP());

        CamaroteInferior ingressoCamaroteInferior = new CamaroteInferior(50, 30, "Setor A");
        System.out.println("Valor do ingresso Camarote Inferior: R$" + ingressoCamaroteInferior.getValorVIP());
        ingressoCamaroteInferior.mostrarLocalizacao();

        CamaroteSuperior ingressoCamaroteSuperior = new CamaroteSuperior(50, 30, 20);
        System.out.println("Valor do ingresso Camarote Superior: R$" + ingressoCamaroteSuperior.getValorVIP());
    }
}
