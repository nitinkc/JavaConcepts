package com.nitin.a19IO.streams.BufferedIOStreams;

import java.io.*;

/**
 * Created by Nitin C on 3/6/2016.
 * instead of writing one byte at a time, read(byte[]) return number of bytes read into the array provided
 * if the value returned is zero = EOF OR
 * if value returned is less than the size of byte array, that was the last read from the file!!
 *
 * for BOS write(byte[],int,int), input byte array, offset and length value
 * offset is the number of values to skip before writing characters, and is often set to zero.
 * the length is the number of characters from the byte array to write
 *
 * WHY Buffered Classes Preferred? The buffered classes contains numerous performance improvements for
 * managing stream data in memory
 *
 * Buffer size tuning :
 */
public class CopyClassUsingBuffIO {
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
        try( //try-with-resource keep the resources within ()
                InputStream in = new BufferedInputStream(new FileInputStream(source));
                OutputStream out = new BufferedOutputStream(new FileOutputStream(destination))
        )//try keeping the resources
        {
            byte[] buffer = new byte[1024];//1 Kb Buffer
            int lenghtRead;
            while ((lenghtRead = in.read(buffer)) > 0){
                out.write(buffer, 0, lenghtRead);
                out.flush();
            }
        }//try with resource ends here
    }
}
