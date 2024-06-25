package br.github.vtspp.chat;

class ChatInteracaoNaoPermitidaException extends RuntimeException {

    public ChatInteracaoNaoPermitidaException(String message) {
        super(message);
    }
}
