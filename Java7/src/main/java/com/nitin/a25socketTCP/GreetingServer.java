package com.nitin.a25socketTCP;

//File Name GreetingServer.java

import java.net.*;
import java.io.*;

public class GreetingServer extends Thread {
   private ServerSocket serverSocket;

   public GreetingServer(int port) throws IOException {
      serverSocket = new ServerSocket(port);
      serverSocket.setSoTimeout(100000);
   }

   public static void main(String[] args) {
      //int port = Integer.parseInt(args[0]);
      int port = 1234;
      try {
         Thread t = new GreetingServer(port);
         t.start();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public void run() {
      Socket server = null;
      DataInputStream in = null;
      DataOutputStream out = null;
      String stringFromClient = "";

      try {
         System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
         server = serverSocket.accept();
         System.out.println("Just connected to " + server.getRemoteSocketAddress());
         in = new DataInputStream(new BufferedInputStream(server.getInputStream()));
         // sends output to the socket
         out = new DataOutputStream(server.getOutputStream());

      } catch (SocketTimeoutException s) {
         System.out.println("Socket timed out!");
         //break;
      } catch (IOException e) {
         e.printStackTrace();
         // break;
      }
      while (!stringFromClient.equalsIgnoreCase("EXIT")) {
         try {
            stringFromClient = in.readUTF();
            out.writeUTF("Received from Client" + stringFromClient);
         } catch (IOException e) {
            e.printStackTrace();
         }
         System.out.println("Received from Client : " + stringFromClient);
      }

      System.out.println("Closing connection");

      try {
         //out.writeUTF("Thank you for connecting to " + server.getLocalSocketAddress() + "\nGoodbye!");
         server.close();
         in.close();
         out.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}