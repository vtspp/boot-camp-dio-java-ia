package br.github.vtspp.financeiro;

public record Transferencia() implements OperacaoFinanceira {

    @Override
    public boolean transacaoConcluida() {
        return false;
    }
}
