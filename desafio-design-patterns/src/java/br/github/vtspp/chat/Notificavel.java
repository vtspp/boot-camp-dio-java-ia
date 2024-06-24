package br.github.vtspp.chat;

import br.github.vtspp.mensagem.Mensagem;

public interface Notificavel {
    void receberNotificacao(Mensagem mensagem);
}
