package br.github.vtspp.conta;

import br.github.vtspp.cliente.Cliente;
import br.github.vtspp.conta.exception.AberturaContaException;

import java.lang.reflect.InvocationTargetException;
import java.util.random.RandomGenerator;

public class AberturaConta {

    public static Conta abrirConta(Cliente cliente, TipoConta tipoConta) {
        try {
            var conta = tipoConta.getContaClass().getDeclaredConstructor(Cliente.class).newInstance(cliente);
            return (Conta) conta;
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            System.err.printf("Ocorreu um erro ao criar uma nova conta devido : %s. Uma nova tentativa será realizada.\n", e.getMessage());
            return abrirConta(cliente, tipoConta);
        }
    }

    protected static String gerarNumeroConta(TipoConta tipoConta) {
        return RandomGenerator.getDefault()
                .longs(1, Long.MAX_VALUE)
                .limit(1)
                .mapToObj(value -> {
                    var numArray = String.valueOf(value).split("");
                    var accumulator = "";
                    for (var i = 0; i < numArray.length; ++i) {
                        accumulator += Long.parseLong(numArray[i]) + Long.parseLong(numArray[i + 1]) + Long.parseLong(numArray[i + 2]);

                        if (accumulator.length() == 8)
                            break;
                    }
                    return accumulator;
                })
                .map(s -> s.substring(0, 8) + "-"+tipoConta.getDigitoVerificador())
                .findFirst()
                .orElseThrow(() -> new AberturaContaException(String.format("Não foi possível gerar o número da %s", tipoConta.getDescricaoConta())));
    }
}
