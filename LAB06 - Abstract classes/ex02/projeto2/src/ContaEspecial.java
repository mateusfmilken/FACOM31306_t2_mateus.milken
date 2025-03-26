public class ContaEspecial extends ContaCorrente {
    private float limite;

    public ContaEspecial(float val, int num, int pwd, float lim) {
        super(val, num, pwd);
        limite = lim;
    }

    @Override
    public boolean debitaValor(float val, int pwd) {
        if (pwd != senha || estado != 1 || val <= 0 || val > saldo + limite) return false;
        saldo -= val;
        return true;
    }

    public ContaComum verificaLimite() {
        if (limite == 0) {
            System.out.println("Convertendo conta especial em comum...");
            return new ContaComum(this.saldo, this.numConta, this.senha);
        }
        return null;
    }
}