package server.persistence.serverSocket;


import client.collection.NodeList;
import client.dto.Dto;
import server.bdConection.DataSource;
import server.bdConection.Entity;

import java.io.*;
import java.net.Socket;


public class SingleTCPEchoServerHybrid extends Thread{

    public static final int PORT = 1234;

    private Socket socket = null;

    private DataSource dataSource = null;

    private ObjectInputStream in;

    private ObjectOutputStream out;

    public SingleTCPEchoServerHybrid(Socket sock, DataSource dataSource)
    {
        this.socket = sock;
        this.dataSource = dataSource;

        try
        {
            in = new ObjectInputStream(socket.getInputStream());

            out = new ObjectOutputStream(socket.getOutputStream());
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
        this.start();
    }

    public void run()
    {

        RequestDataBase sql= null;

        try
        {
            do{
                sql = (RequestDataBase) in.readObject();

                System.out.println("Message recived" +" "+sql.toString());

                if(sql.getOperation() != TypeOperation.EXIT) {

                    Entity<Dto> entity = new Entity<>(sql.getEntity());
                    NodeList<?> nodeList = (NodeList<?>) Operation.doOperation(sql, entity);
                    out.writeObject( nodeList);
                }
            }while(sql.getOperation() != TypeOperation.EXIT);


            System.out.println("Client disconnected...");
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());

        }
        finally
        {
            try
            {
                this.socket.close();
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
    }
}