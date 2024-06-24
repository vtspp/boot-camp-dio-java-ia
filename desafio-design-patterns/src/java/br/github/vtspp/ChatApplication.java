package br.github.vtspp;

import br.github.vtspp.chat.Participante;
import br.github.vtspp.sala.Sala;

import java.util.UUID;

public class ChatApplication {

    public static void main(String[] args) {
        var partipanteA = new Participante(UUID.randomUUID(), "Nicholas");
        var participanteB = new Participante(UUID.randomUUID(), "Nathan");

        var sala = new Sala();
        sala.entrarSala(partipanteA, participanteB);
    }
}
