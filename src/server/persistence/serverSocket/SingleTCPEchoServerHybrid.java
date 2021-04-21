package server.persistence.serverSocket;


import client.collection.NodeList;
import client.dto.Dto;
import client.dto.FacultyDto;
import client.dto.PlayerDto;
import client.dto.TeamDto;
import server.bdConection.DataSource;
import server.bdConection.Entity;
import server.persistence.serverSocket.Operation;
import server.persistence.serverSocket.RequestDataBase;
import server.persistence.serverSocket.TypeOperation;


import java.io.*;
import java.net.Socket;
import java.sql.Connection;
import java.sql.ResultSet;

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

        try
        {
            RequestDataBase sql= null;
            do
            {
                sql = (RequestDataBase) in.readObject();

                if(sql.getOperation() != TypeOperation.EXIT) {

                        Entity<Dto> entity = new Entity<>(sql.getEntity());
                        NodeList<Dto> dtoNodeList = (NodeList<Dto>) Operation.doOperation(sql, entity);
                        out.writeObject(dtoNodeList);
                }
            } while(sql.getOperation() != TypeOperation.EXIT);/**request.getOperation() != TypeOperation.EXIT **/

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
                in.close();
                out.close();
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
    }
}