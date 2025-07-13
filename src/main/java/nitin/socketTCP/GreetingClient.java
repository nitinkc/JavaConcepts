package nitin.socketTCP;

// File Name GreetingClient.java

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class GreetingClient {
    public static void main(String[] args) throws IOException {
        // args[0] = 127.0.0.1, args[1] = 1234
        // String serverName = args[0];
        // int port = Integer.parseInt(args[1]);
        String serverName = "localhost";
        int port = 1234;
        DataInputStream in = null;
        DataOutputStream out = null;
        Socket client = null;
        String sendToServer = "";
        try {
            System.out.println("Connecting to Server" + serverName + " on port " + port);
            client = new Socket(serverName, port);
            System.out.println("Just connected to " + client.getRemoteSocketAddress());
            // Writes data to the socket
            out = new DataOutputStream(client.getOutputStream());
            // in = new DataInputStream(new BufferedInputStream(client.getInputStream()));
            // Take the input from Terminal
            in = new DataInputStream(System.in);
            // Sending data to the server
        } catch (IOException e) {
            e.printStackTrace();
        }

        out.writeUTF("Hello from " + client.getLocalSocketAddress());

        while (!sendToServer.equalsIgnoreCase("exit")) {
            try {
                sendToServer = in.readLine();
                out.writeUTF(sendToServer);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Sending to Server " + sendToServer);
            // System.out.println("Server says " + in.readUTF());
        }

        out.close();
        client.close();
        in.close();
    }
}
