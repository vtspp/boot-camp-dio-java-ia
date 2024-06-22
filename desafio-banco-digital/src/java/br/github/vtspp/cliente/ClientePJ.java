package br.github.vtspp.cliente;

public record ClientePJ(String razaoSocial, String numeroCNPJ) implements Cliente {

    @Override
    public String nome() {
        return razaoSocial;
    }

    @Override
    public String numeroDocumento() {
        return numeroCNPJ;
    }
}
