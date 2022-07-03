package tech.kitucode.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketHelper {

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void start(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Waiting for client connections");
            clientSocket = serverSocket.accept();
            System.out.println("A client connected|" + clientSocket.getInetAddress().getCanonicalHostName() + " with port "
                    + clientSocket.getPort() + "| through server port " + clientSocket.getLocalPort());
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String greeting = in.readLine();
            if (greeting.equalsIgnoreCase("Hello Server")) {
                out.println("Hello client");
            } else {
                out.println("Unsupported greeting");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void stop() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }
}
