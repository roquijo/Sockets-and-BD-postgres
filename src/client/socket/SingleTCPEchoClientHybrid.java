package client.socket;

import client.collection.NodeList;
import mvc.controller.ControllerBuildObject;
import server.persistence.serverSocket.RequestDataBase;

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
    RequestDataBase requestDataBase;

    public RequestDataBase getRequestDataBase() {
        return requestDataBase;
    }

    public void setRequestDataBase(RequestDataBase requestDataBase) {
        this.requestDataBase = requestDataBase;
    }
/*
    public static void main(String[] args)
    {
        new SingleTCPEchoClientHybrid();
    }
 */

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
    }

    public void run() {

        Socket sock = null;

        try
        {
             sock = new Socket(host, PORT);

             InputStream inputStream = sock.getInputStream();
             in = new ObjectInputStream(inputStream);
             out = new ObjectOutputStream(sock.getOutputStream());

             out.writeObject(requestDataBase);

             NodeList<Object> nodeList = (NodeList<Object>) in.readObject();

                for (int i = 0; i < nodeList.getSize(); i++) {
                    System.out.println(nodeList.pop(i));
                }
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
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
