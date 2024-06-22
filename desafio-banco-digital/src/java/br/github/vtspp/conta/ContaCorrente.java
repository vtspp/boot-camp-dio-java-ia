package br.github.vtspp.conta;

import br.github.vtspp.cliente.Cliente;
import br.github.vtspp.financeiro.OperacaoFinanceira;

import java.time.LocalDateTime;

class ContaCorrente extends Conta {

    private OperacaoFinanceira operacaoFinanceira;

    public ContaCorrente(Cliente cliente) {
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
        return true;
    }

    @Override
    public TipoConta tipoConta() {
        return TipoConta.CONTA_CORRENTE;
    }
}
