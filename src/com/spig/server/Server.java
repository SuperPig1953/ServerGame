package com.spig.server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Server {

    Socket soc;

    ServerSocket s = null;
    private ArrayList<ServerHandle> connections;

    public Server() throws IOException
    {
        try
        {
            s = new ServerSocket(25565);
            System.out.println("running on port 25565");
            ExecutorService pool = Executors.newFixedThreadPool(3);
            System.out.println("..pool..");
            while(true)
            {
                soc =s.accept();
                ServerHandle handle = new ServerHandle(soc);

                pool.execute(handle);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
            //should be e.printStackTrace();
        }
        finally
        {
            if(s != null)
            {
                s.close();
            }
        }
    }
    public void broadcast(String message){
        for (ServerHandle ch : connections){
            if(ch != null){
                ch.toClient.println("sasa");
            }
        }
    }
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

        try {
            new Server();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}