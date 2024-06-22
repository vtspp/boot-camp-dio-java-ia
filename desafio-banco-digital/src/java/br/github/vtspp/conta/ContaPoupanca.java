package br.github.vtspp.conta;

import br.github.vtspp.cliente.Cliente;
import br.github.vtspp.financeiro.OperacaoFinanceira;

import java.time.LocalDateTime;

class ContaPoupanca extends Conta {

    private OperacaoFinanceira operacaoFinanceira;

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    public LocalDateTime dataAbertura() {
        return dataAbertura;
    }

    @Override
    public String numeroConta() {
        return numeroConta;
    }

    @Override
    public short digitoVerificador() {
        return tipoConta().getDigitoVerificador();
    }

    @Override
    public double saldo() {
        return 0;
    }

    @Override
    public boolean ativa() {
        return false;
    }

    @Override
    public TipoConta tipoConta() {
        return TipoConta.CONTA_POUPANCA;
    }
}
