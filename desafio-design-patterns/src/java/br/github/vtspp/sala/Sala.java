package br.github.vtspp.sala;

import br.github.vtspp.chat.Chat;
import br.github.vtspp.chat.Participante;

public class Sala {

    private static final int MINIMO_PARTICIPANTES = 2;
    private boolean aberta;

    public void entrarSala(Participante ... participantes) {

        if (participantes.length < MINIMO_PARTICIPANTES)
            throw new SalaChatNaoPodeSerAbertaException(String.format("A sala precisa de no mínimo %d participantes para ser aberta.", MINIMO_PARTICIPANTES));

        this.aberta = true;
        new Chat(this, participantes);
    }

    public boolean isAberta() {
        return aberta;
    }

    public void fecharSala() {
        aberta = false;
    }
}
