public abstract class ContaCorrente {
    protected float saldo;
    protected int estado; // 1 = ativa, 2 = inativa
    protected int numConta;
    protected int senha;

    public ContaCorrente(float val, int num, int pwd) {
        numConta = num;
        senha = pwd;
        saldo = val;
        estado = 1;
    }

    public abstract boolean debitaValor(float val, int pwd);

    public float getSaldo(int pwd) {
        if (senha == pwd) return saldo;
        else return -1;
    }

    public void creditaValor(int pwd, float val) {
        if (senha == pwd) saldo += val;
    }

    protected int getEstado(int pwd) {
        if (senha == pwd) return estado;
        else return -1;
    }

    protected void setEstado(int pwd, int e) {
        if (senha == pwd) estado = e;
    }

    protected boolean isSenha(int pwd) {
        return senha == pwd;
    }
}