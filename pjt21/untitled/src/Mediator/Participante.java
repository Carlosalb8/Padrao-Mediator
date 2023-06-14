package Mediator;

abstract class Participante  {
    protected Mediator mediator;

    public Participante(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void enviarMensagem(String mensagem);
    public abstract void receberMensagem(String mensagem);
}
