package br.github.vtspp.chat;

import br.github.vtspp.mensagem.MensagemTexto;

import java.util.UUID;

public record Participante (UUID id, String nome) implements Notificador {

    @Override
    public void notificar(Notificavel chat) {
        var text = Chat.interagir();
        chat.receberNotificacao(new MensagemTexto(nome, text));
    }
}
