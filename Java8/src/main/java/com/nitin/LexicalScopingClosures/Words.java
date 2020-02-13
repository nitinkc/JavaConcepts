package com.nitin.LexicalScopingClosures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.stream.Collectors;

/**
 * Created by nitin on Thursday, February/13/2020 at 1:53 AM
 */
public class Words {
    public static void main(String[] args) {
        try {
            final URL url =
                    new URL("https://api.datamuse.com/words?ml=duck&amp;max=100");
            final BufferedReader reader =
                    new BufferedReader(new InputStreamReader(url.openStream()));

            System.out.println(reader.readLine());
            final String data = reader.lines().collect(Collectors.joining());

            final String[] dataItems = data.split(",");

        } catch(Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
