package nitin.a1languageFundamentals;

import java.io.*;

public class IntelliJShortcuts {

    private static final String FILE = "src/main/resources/nitin.txt";

    public static void main(String[] args) throws IOException {

        FileReader in = new FileReader(new File(FILE));
        BufferedReader bufferedReader = new BufferedReader(in);
        bufferedReader
                .lines()
                .forEach(
                        str -> {
                            String[] s = str.split(" ");
                            for (String string : s) {
                                System.out.println(string.toUpperCase());
                            }
                        });

        bufferedReader.close();
    }
}
