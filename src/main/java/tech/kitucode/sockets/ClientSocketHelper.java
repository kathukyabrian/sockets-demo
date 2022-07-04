package tech.kitucode.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSocketHelper {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void startConnection(String ip, int port) {
        try {
            clientSocket = new Socket(ip, port);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String sendMessage(String message) {
        out.println(message);
        try {
            String response = in.readLine();
            return message;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void stopConnection() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
    }

    public static void main(String[] args) {
        ClientSocketHelper clientSocketHelper = new ClientSocketHelper();
        clientSocketHelper.startConnection("127.0.0.1", 8000);
        String message = clientSocketHelper.sendMessage("Hello Server");
        System.out.println("Message is " + message);
    }
}
