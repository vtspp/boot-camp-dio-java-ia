package br.github.vtspp.financeiro;

public record Deposito() implements OperacaoFinanceira {
    @Override
    public boolean transacaoConcluida() {
        return false;
    }
}
