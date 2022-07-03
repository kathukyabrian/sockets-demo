package tech.kitucode.characterstreams;

import java.io.*;

public class Helper {
    public void readDataFromFileUsingFileReader(){
        long start = System.currentTimeMillis();
        // create an array where the data will be read into
        char[] array = new char[100];

        try {
            Reader input = new FileReader("names.txt");

            // check if reader is ready
            System.out.println("There is data in the stream? : "+input.ready());

            // read the data and save it to array
            input.read(array);
            System.out.println("Data in the stream : ");
            System.out.println(array);

            input.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        long finish = System.currentTimeMillis();

        System.out.println("This operation took " + (int)(finish - start)  + " ms");
    }

    public void readDataFromFileUsingBufferedReader(){
        long start = System.currentTimeMillis();

        char[] array = new char[100];

        try {
            Reader input = new FileReader("names.txt");
            BufferedReader bufferedReader = new BufferedReader(input);

            bufferedReader.read(array);
            System.out.println("Data in the file : ");
            System.out.println(array);

            input.close();
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        long finish = System.currentTimeMillis();

        System.out.println("This operation took " + (int)(finish - start)  + " ms");
    }
}
