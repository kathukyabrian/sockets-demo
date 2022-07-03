package tech.kitucode;

import java.io.*;

public class Streams {
    public void writeToFile() {
        // 3 classes
        // FileOutputStream
        // ByteArrayOutputStream
        // ObjectOutputStream

        // contents I want to write
        String dadName = "Julius\n";
        String mumName = "Catherine\n";

        try {
            OutputStream out = new FileOutputStream("name.txt", true);
            out.write(dadName.getBytes());
            out.write(mumName.getBytes());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readFromFile() {
        // create a byte array where the data shall be read into
        byte[] data = new byte[100];
        try {
            InputStream in = new FileInputStream("name.txt");
            System.out.println("Number of bytes in file " + in.available());
            in.read(data);

            String dataStr = new String(data);
            System.out.println("The data is : " + dataStr);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void objectStreaming(){
        Car car = new Car("Subaru", "2000", 2009);
        try {
            // convert to a byte stream(serialization)
            OutputStream out = new FileOutputStream("car.txt");
            ObjectOutputStream objOut = new ObjectOutputStream(out);

            // this encodes the contents with the class name -> you can't read normally
            objOut.writeObject(car);

            // to read this, you need to use an input stream(deserialization)
            FileInputStream fileInputStream = new FileInputStream("car.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            System.out.println("The data is "+ objectInputStream.readObject());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
