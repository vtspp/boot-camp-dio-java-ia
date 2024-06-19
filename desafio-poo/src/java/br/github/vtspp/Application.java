package br.github.vtspp;

import br.github.vtspp.apple.Iphone2007;
import br.github.vtspp.interfaces.Iphone;

import java.lang.reflect.InvocationTargetException;

public class Application {
    public static void main(String[] args) {
        try {
            enableIphoneDebug(new Iphone2007());
        } catch (Exception e) {
            System.err.print("Erro ao executar Iphone no modo debug");
        }
    }

    private static void enableIphoneDebug(final Iphone iphone) throws InvocationTargetException, IllegalAccessException, InterruptedException {
        for (var method : iphone.getClass().getDeclaredMethods()) {
            method.invoke(iphone);
            Thread.sleep(2000);
        }
    }
}
