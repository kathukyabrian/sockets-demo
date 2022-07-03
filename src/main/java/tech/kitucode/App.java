package tech.kitucode;


import tech.kitucode.bytestreams.Helper;

public class App
{
    public static void main( String[] args )
    {
        Helper streams = new Helper();
        streams.writeToFile();
        streams.readFromFile();
        streams.objectStreaming();

        tech.kitucode.characterstreams.Helper helper = new tech.kitucode.characterstreams.Helper();
        helper.readDataFromFileUsingFileReader();
        helper.readDataFromFileUsingBufferedReader();
    }
}
