package Mediator;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MediatorTest {
    @Test
    void testMediator() {
        // Redefine a saída padrão para capturar as mensagens impressas
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Cria o mediador
        ChatMediator chatMediator = new ChatMediator();

        // Cria os participantes
        Participante usuario1 = new Usuario("Gabriel", chatMediator);
        Participante usuario2 = new Usuario("BH", chatMediator);
        Participante usuario3 = new Usuario("Charlie", chatMediator);
        chatMediator.adicionarParticipante(usuario1);
        chatMediator.adicionarParticipante(usuario2);
        chatMediator.adicionarParticipante(usuario3);

        // Envia as mensagens
        usuario1.enviarMensagem("Olá a todos!");
        usuario2.enviarMensagem("Olá Gabriel!");
        usuario3.enviarMensagem("Olá BH!");

        // Verifica as mensagens recebidas
        String output = outputStream.toString().trim();
        String[] outputLines = output.split("\n");

        assertTrue(output.contains("Gabriel enviou a mensagem: Olá a todos!"));
        assertTrue(output.contains("BH recebeu a mensagem: Olá a todos!"));
        assertTrue(output.contains("BH enviou a mensagem: Olá Gabriel!"));
        assertTrue(output.contains("Gabriel recebeu a mensagem: Olá Gabriel!"));
        assertTrue(output.contains("Charlie enviou a mensagem: Olá BH!"));
        assertTrue(output.contains("BH recebeu a mensagem: Olá BH!"));
    }
}






