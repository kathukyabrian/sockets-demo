package tech.kitucode;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class App
{
    public static void main( String[] args )
    {
        Streams streams = new Streams();
        streams.writeToFile();
        streams.readFromFile();

        streams.objectStreaming();
    }
}
