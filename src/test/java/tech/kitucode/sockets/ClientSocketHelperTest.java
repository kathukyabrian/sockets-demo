package tech.kitucode.sockets;

import org.junit.Test;

public class ClientSocketHelperTest {

    @Test
    public void givenClientSocket(){
        ClientSocketHelper clientSocketHelper = new ClientSocketHelper();
        clientSocketHelper.startConnection("127.0.0.1", 8000);
        String message = clientSocketHelper.sendMessage("Hello Server");
        System.out.println("Message is " + message);
        assert(message.equalsIgnoreCase("hello client"));
    }
}
