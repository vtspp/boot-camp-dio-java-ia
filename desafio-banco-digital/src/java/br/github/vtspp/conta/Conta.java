package br.github.vtspp.conta;

import br.github.vtspp.cliente.Cliente;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.random.RandomGenerator;

public abstract class Conta {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");

    protected final Cliente cliente;
    protected String numeroConta;
    protected LocalDateTime dataAbertura;

    protected Conta(Cliente cliente) {
        this.cliente = cliente;
        this.dataAbertura = LocalDateTime.now();
        this.numeroConta = AberturaConta.gerarNumeroConta(tipoConta());
    }

    abstract LocalDateTime dataAbertura();
    abstract String numeroConta();
    abstract short digitoVerificador();
    abstract double saldo();
    abstract boolean ativa();
    abstract TipoConta tipoConta();

    public String extratoBancario() {
        final var doisPontos = " : ";
        final var quebraLinha = "\n";

        try {
            var processing = true;
            while (processing) {
                System.out.println("Estamos processando seu extrato. Obrigado por aguardar...");
                Thread.sleep(3000);
                processing = RandomGenerator.getDefault().nextBoolean();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return new StringBuilder("### Extrato Bancário ###").append(quebraLinha)
                .append("Data Abertura").append(doisPontos).append(DATE_FORMATTER.format(dataAbertura())).append(quebraLinha)
                .append(tipoConta().getDescricaoConta()).append(doisPontos).append(numeroConta()).append(quebraLinha)
                .append("Nome").append(doisPontos).append(cliente.nome()).append(quebraLinha)
                .append("Data da consulta").append(doisPontos).append(DATE_FORMATTER.format(LocalDateTime.now())).append(quebraLinha)
                .append("Saldo").append(doisPontos).append(String.format("%.2f", saldo())).append(quebraLinha)
                .append("### Fim do Extrato bancário ###")
                .toString();
    }
}
