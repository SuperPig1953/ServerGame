package com.superpig1953.server;

import com.superpig1953.server.handler.PacketManager;

import java.io.*;
import java.net.*;

public class Server {

    private static final String IP = "127.0.0.1";

    private static final int PORT = 25565;

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(PORT, 50, InetAddress.getByName(IP))) {
            System.out.println("Server started: " + serverSocket);

            try (Socket socket = serverSocket.accept()) {
                System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

                try (BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter output = new PrintWriter(socket.getOutputStream(), true)) {

                    String message;
                    while ((message = input.readLine()) != null) {
                        PacketManager.handlePacket(message);
                    }
                }
            }
        }
    }

}
