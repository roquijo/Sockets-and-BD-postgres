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

    private BufferedReader in;

    private ObjectOutputStream out;

    private Connection con;

    public SingleTCPEchoServerHybrid(Socket sock, DataSource dataSource)
    {
        this.socket = sock;
        this.dataSource = dataSource;

        try
        {
            in =new BufferedReader(new InputStreamReader(socket.getInputStream()));

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
            RequestDataBase request;
            int numMsg = 0;
            String sql= null;
            do
            {
                sql = in.readLine();

                if(!sql.equalsIgnoreCase("EXIT")) {
                    if (sql.contains("player")) {
                        PlayerDto playerDto = new PlayerDto();
                        ResultSet resultSet = dataSource.runExecuteQuery(sql);
                        Entity<Dto> entity = new Entity<Dto>(playerDto.getClass());
                        NodeList<Dto> facultyDtoNodeList = entity.getMultipleRows(resultSet);
                        out.writeObject(facultyDtoNodeList);
                    } else if (sql.contains("team")) {
                        TeamDto teamDto = new TeamDto();
                        ResultSet resultSet = dataSource.runExecuteQuery(sql);
                        Entity<Dto> entity = new Entity<Dto>(teamDto.getClass());
                        NodeList<Dto> teamDtoNodeList = entity.getMultipleRows(resultSet);
                        out.writeObject(teamDtoNodeList);
                    } else {
                        FacultyDto facultyDto = new FacultyDto();
                        ResultSet resultSet = dataSource.runExecuteQuery(sql);
                        Entity<Dto> entity = new Entity<Dto>(facultyDto.getClass());
                        NodeList<Dto> facultyDtoNodeList = entity.getMultipleRows(resultSet);
                        out.writeObject(facultyDtoNodeList);
                    }
                }
            } while(!sql.equalsIgnoreCase("EXIT")/**request.getOperation() != TypeOperation.EXIT **/);

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