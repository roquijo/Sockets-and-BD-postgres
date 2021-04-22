package client.socket;

import client.collection.NodeList;
import server.persistence.serverSocket.RequestDataBase;
import server.persistence.serverSocket.TypeOperation;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SingleTCPEchoClientHybrid
{

    private InetAddress host;
    private static final int   PORT = 1234;
    ObjectInputStream in;
    ObjectOutputStream out;


    public static void main(String[] args)
    {
        new SingleTCPEchoClientHybrid();
    }

    public SingleTCPEchoClientHybrid()
    {
        System.out.println("Port open");
        try
        {
            //Se busca el Host
            host = InetAddress.getLocalHost();
        }
        catch (UnknownHostException e)
        {
            System.out.println("Host not found!");
            System.exit(1);
        }
        run();
    }

    private void run() {

        Socket sock = null;

        try
        {
             sock = new Socket(host, PORT);
             in = new ObjectInputStream((sock.getInputStream()));
             out = new ObjectOutputStream(sock.getOutputStream());
             RequestDataBase sql= null;

            do {
                
                out.writeObject(sql);

                NodeList<Object> nodeList = (NodeList<Object>) in.readObject();

                for (int i = 0; i < nodeList.getSize(); i++) {

                    System.out.println(nodeList.pop(i));
                
                }

            } while (sql.getOperation() != TypeOperation.EXIT);
        }
        catch (IOException | ClassNotFoundException e)
        {

            System.out.println(e.getMessage());
        }
        finally
        {
            try
            {
                sock.close();
                in.close();
                out.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
