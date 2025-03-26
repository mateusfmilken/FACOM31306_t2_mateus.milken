public class UsaBanco {
    public static void main(String[] args) {
        ContaEspecial c[] = new ContaEspecial[1];
        c[0] = new ContaEspecial(1000, 1234, 123, 500);

        System.out.println("Saldo antes do débito: " + c[0].getSaldo(123));
        c[0].debitaValor(900, 123);
        System.out.println("Saldo após o débito: " + c[0].getSaldo(123));

        ContaComum cc = c[0].verificaLimite();
        if (cc != null) {
            System.out.println("Conta foi convertida para Conta Comum");
            System.out.println("Saldo da Conta Comum: " + cc.getSaldo(123));
        }
    }
}