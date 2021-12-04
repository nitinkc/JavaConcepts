package java7.a19IO.streams.FileIOStream;

import java.io.*;

/**
 * Created by Nitin C on 3/6/2016.
 * A class file is a
 *
 * While reading a single value of a file input stream instance, the read method returns a primitive int value
 * rather than a byte value. If the class does return a byte instead of an int, then there no is no way to know EOF.
 * For compatibility, the file output stream also uses int instead of byte for writing a single byte to a file.
 */
public class CopyClass {
    public static void main(String[] args) {
        // Binary File (Serialized file) to read binary data
        //File source = new File("s.out");
        File source = new File("N1PathFileTest.class");
        File destination = new File("s_copy.out");//Override mode

        try {
            copy(source,destination);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copy(File source, File destination) throws IOException {
        InputStream in = new FileInputStream(source);

        OutputStream out = new FileOutputStream(destination);

        int b;

        // The performance for large files would not be good as as it does not use any byte arrays
        while ((b = in.read()) != -1){//-1 is the EOF
            out.write(b);
            System.out.println(b);
        }
    }

}
