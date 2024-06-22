package br.github.vtspp.conta;

public enum TipoConta {
    CONTA_CORRENTE(ContaCorrente.class, "Conta Corrente", (short) 12),
    CONTA_POUPANCA(ContaPoupanca.class, "Conta Poupança", (short) 13);

    private Class<?> contaClass;
    private String descricaoConta;
    private short digitoVerificador;

    TipoConta(Class<?> contaClass, String descricaoConta, short digitoVerificador) {
        this.contaClass = contaClass;
        this.descricaoConta = descricaoConta;
        this.digitoVerificador = digitoVerificador;
    }

    public Class<?> getContaClass() {
        return contaClass;
    }

    public String getDescricaoConta() {
        return descricaoConta;
    }

    public short getDigitoVerificador() {
        return digitoVerificador;
    }
}
