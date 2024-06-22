package br.github.vtspp.cliente;

public record ClientePF(String nome, String cpf) implements Cliente {

    @Override
    public String nome() {
        return nome;
    }

    @Override
    public String numeroDocumento() {
        return cpf;
    }
}
