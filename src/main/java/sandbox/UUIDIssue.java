package sandbox;

import nitin.io.fileIO.readfiles1.XsAndYs;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class UUIDIssue {
    public static void main(String[] args) {

        String numberAsString = "00693";
        UUID uuidString = null;

        try {
            uuidString = UUID.fromString(numberAsString);
        } catch (IllegalArgumentException e){
            System.err.println(e.toString());
        }
        System.out.println(uuidString);

        try {
            uuidString = UUID.nameUUIDFromBytes(numberAsString.getBytes(StandardCharsets.UTF_8));
        }catch (Exception e){
            System.out.println(e.toString());
        }
        System.out.println(uuidString);
    }
}
