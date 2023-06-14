package Mediator;

import java.util.ArrayList;
import java.util.List;

// Classe Concreta Mediator
class ChatMediator implements Mediator {
    private List<Participante> participantes;

    public ChatMediator() {
        this.participantes = new ArrayList<>();
    }

    public void adicionarParticipante(Participante participante) {
        participantes.add(participante);
    }

    @Override
    public void enviarMensagem(String mensagem, Participante remetente) {
        for (Participante participante : participantes) {
            if (participante != remetente) {
                participante.receberMensagem(mensagem);
            }
        }
    }
}
