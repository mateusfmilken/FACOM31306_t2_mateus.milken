public class CamaroteSuperior extends VIP {
    private double valorAdicionalExtra;

    public CamaroteSuperior(double valor, double valorAdicional, double valorAdicionalExtra) {
        super(valor, valorAdicional);
        this.valorAdicionalExtra = valorAdicionalExtra;
    }

    @Override
    public double getValorVIP() {
        return super.getValorVIP() + valorAdicionalExtra;
    }
}