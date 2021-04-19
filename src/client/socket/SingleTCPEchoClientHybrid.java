package client.socket;

import client.collection.NodeList;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SingleTCPEchoClientHybrid
{

    private InetAddress host;
    private static final int   PORT = 1234;
    ObjectInputStream in;
    PrintWriter out;


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
            int numMsg = 0;


            sock = new Socket(host, PORT);
             in = new ObjectInputStream((sock.getInputStream()));
             out = new PrintWriter(sock.getOutputStream(), true);

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String msgOut, msgIn;
            Object input;

            do {
                System.out.println("Enter sql statement: ");
                msgOut = reader.readLine();

                out.println(msgOut);

                NodeList<Object> nodeList = (NodeList<Object>) in.readObject();
                for (int i = 0; i < nodeList.getSize(); i++) {

                    System.out.println(nodeList.pop(i));
                }

            } while (!msgOut.equalsIgnoreCase("EXIT"));
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
