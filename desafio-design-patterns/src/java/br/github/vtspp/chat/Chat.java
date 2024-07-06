package br.github.vtspp.chat;

import br.github.vtspp.mensagem.Mensagem;
import br.github.vtspp.sala.Sala;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Chat implements Notificavel {

    private static final String SAIR = "sair";
    private static final int MINIMO_PARTICIPANTES = 2;
    private static final Scanner scanner = new Scanner(System.in);
    private static final Set<Notificador> participantes = new HashSet<>(MINIMO_PARTICIPANTES);
    private final Sala sala;

    public Chat(Sala sala, Notificador... participantes) {
        this.sala = sala;
        Chat.participantes.addAll(Arrays.asList(participantes));
        iniciarChat();
    }

    private void iniciarChat() {
        System.out.println("############# Chat inciado ############# \n"
                           + "Digite alguma coisa e dê 'Enter' para começar uma conversa \n ");

        while (sala.isAberta() && temParticipantes()) {
            Chat.participantes.forEach(participante -> {
                if (sala.isAberta())
                    participante.notificar(this);
            });
        }
        System.out.println("############# Chat encerrado #############");
    }

    public static String interagir() {
        if (naoPodeInteragirComChat())
            throw new ChatInteracaoNaoPermitidaException("Só é permitido interagir com o chat quanto há participantes");
        return scanner.nextLine();
    }

    @Override
    public void receberNotificacao(Mensagem mensagem) {

        if (sair(mensagem.conteudo())) {
            encerrarChat(mensagem.remetente());
            return;
        }

        System.out.println(mensagem.remetente() + ": " + mensagem.conteudo());
    }

    private static boolean naoPodeInteragirComChat() {
        return naoTemParticipantes();
    }

    private boolean temParticipantes() {
        return !Chat.participantes.isEmpty() && temMinimoParticipantes();
    }

    private static boolean naoTemParticipantes() {
        return naoTemMinimoParticipantes();
    }

    private boolean temMinimoParticipantes() {
        return Chat.participantes.size() >= MINIMO_PARTICIPANTES;
    }

    private static boolean naoTemMinimoParticipantes() {
        return Chat.participantes.isEmpty() || Chat.participantes.size() < MINIMO_PARTICIPANTES;
    }

    private boolean sair(String mensagem) {
        return SAIR.equalsIgnoreCase(mensagem);
    }

    private void encerrarChat(String nomeRemente) {
        scanner.close();
        sala.fecharSala();
        System.out.println(nomeRemente + " saiu do chat.");
    }
}
