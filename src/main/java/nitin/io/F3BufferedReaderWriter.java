package nitin.io;

import java.io.*;

/** Created by nitin on 1/2/16. */
public class F3BufferedReaderWriter {
    public static void main(String[] args) throws IOException {

        File f = new File("src/com/nitin/IO_FileHandling/nitin.txt");

        // Buffered Writer needs a WRITER a5object to communicate with File
        FileWriter fw = new FileWriter(f, true);

        BufferedWriter bw = new BufferedWriter(fw);

        bw.write(100);
        bw.newLine();
        bw.write("Nitin");
        bw.newLine();
        bw.flush();

        // Reading the File
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);

        // We have a String in Return
        String line = br.readLine();

        while (line != null) { // The EOF is null!!
            System.out.println(line);
            line = br.readLine();
        }

        bw.close();
        br.close();
    }
}
