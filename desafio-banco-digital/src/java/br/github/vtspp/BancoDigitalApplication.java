package br.github.vtspp;

import br.github.vtspp.cliente.ClientePF;
import br.github.vtspp.conta.AberturaConta;
import br.github.vtspp.conta.TipoConta;

public class BancoDigitalApplication {
    public static void main(String[] args) {

        var cliente = new ClientePF("Victor", "123456789");

        var contaCorrente = AberturaConta.abrirConta(cliente, TipoConta.CONTA_CORRENTE);
        System.out.println(contaCorrente.extratoBancario());
    }
}
