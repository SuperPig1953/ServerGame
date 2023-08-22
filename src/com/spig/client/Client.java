package com.spig.client;
import java.io.*;
import java.net.*;
public class Client {

    public static void main(String[] args) {
        String hostname = "192.168.1.39";
        int port = 25565;

        try (Socket clientSocket = new Socket(hostname, port)) {
            while(true) {
                BufferedReader fromUser = new BufferedReader(new InputStreamReader(System.in));

                DataOutputStream toServer = new DataOutputStream(clientSocket.getOutputStream());
                BufferedReader fromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                System.out.println(fromServer.readLine());
                toServer.write(16787899);
            }


        } catch (UnknownHostException ex) {

            System.out.println("Server not found: " + ex.getMessage());

        } catch (IOException ex) {

            System.out.println("I/O error: " + ex.getMessage());
        }
    }
}