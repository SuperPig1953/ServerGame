package com.spig.server;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;


public class ServerHandle implements Runnable {

    Socket s1;
    BufferedReader fromClient;
    PrintWriter toClient;
    String msg;
    private static int id = 0;
    public ServerHandle(Socket s1)
    {
        this.s1 = s1;
        id++;
    }

    public void run()
    {
        try {
            System.out.println("Join with id: "+id);
            while(!s1.isClosed()){
            fromClient = new BufferedReader(new InputStreamReader(s1.getInputStream()));
            toClient = new PrintWriter(new OutputStreamWriter(s1.getOutputStream()));
            System.out.println("client sent"+fromClient.readLine()
            );

            toClient.println("con cac");
            toClient.write("con cac1");
        }}
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally
        {
            try {
                s1.close();
                fromClient.close();
                toClient.close();
                System.out.println("client disconnect");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}