package br.github.vtspp.financeiro;

public record Saque () implements OperacaoFinanceira {

    @Override
    public boolean transacaoConcluida() {
        return false;
    }
}
