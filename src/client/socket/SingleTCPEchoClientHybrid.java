package client.socket;

import client.collection.NodeList;
import client.dto.Faculty;
import client.dto.Player;
import client.dto.Team;
import server.dto.Dto;
import server.persistence.serverSocket.RequestDataBase;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SingleTCPEchoClientHybrid
{

    private InetAddress host;
    private static final int   PORT = 1234;
    private Socket socket = null;
    ObjectInputStream in;
    ObjectOutputStream out;
    RequestDataBase requestDataBase;
    static NodeList<Dto> lista;
    

    public RequestDataBase getRequestDataBase() {
        return requestDataBase;
    }

    public void setRequestDataBase(RequestDataBase requestDataBase) {
        this.requestDataBase = requestDataBase;
    }

    public SingleTCPEchoClientHybrid()
    {

        System.out.println("Port open");
        try
        {
            //Se busca el Host
            host = InetAddress.getLocalHost();

            socket = new Socket(host, PORT);

            out = new ObjectOutputStream(socket.getOutputStream());
        }
        catch (UnknownHostException e)
        {
            System.out.println("Host not found!");
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {

        try
        {
            do{
                out.writeObject(requestDataBase);

                in = new ObjectInputStream(socket.getInputStream());
                
                lista = (NodeList<Dto>) in.readObject();
            }while (requestDataBase != null);


        }
        catch (IOException | ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            try
            {
                socket.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    public NodeList<Dto> getLista() {
        return lista;
    }

    public void setLista(NodeList<Dto> lista) {
        this.lista = lista;
    }
}
