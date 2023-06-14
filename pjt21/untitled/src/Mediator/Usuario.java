package Mediator;

class Usuario extends Participante {
    private String nome;

    public Usuario(String nome, Mediator mediator) {
        super(mediator);
        this.nome = nome;
    }

    @Override
    public void enviarMensagem(String mensagem) {
        System.out.println(nome + " enviou a mensagem: " + mensagem);
        mediator.enviarMensagem(mensagem, this);
    }

    @Override
    public void receberMensagem(String mensagem) {
        System.out.println(nome + " recebeu a mensagem: " + mensagem);
    }
}
