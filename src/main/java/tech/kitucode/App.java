package tech.kitucode;


import tech.kitucode.bytestreams.Helper;
import tech.kitucode.sockets.ServerSocketHelper;

public class App
{
    public static void main( String[] args )
    {
        ServerSocketHelper helper = new ServerSocketHelper();
        helper.start(8000);
    }
}
