package server.persistence.serverSocket;

import server.bdConection.DataSource;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiTCPEchoServer {


    public static final int PORT = 1234;
    private ServerSocket serverSocket;
    private Socket sock = null;
    DataSource dataSource;

    public static void main(String[] args) {

        new MultiTCPEchoServer();
    }

    public MultiTCPEchoServer() {

        dataSource = DataSource.getInstance();

        System.out.println("Opening Port ...");

        try {
            serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            System.out.println("Port Error!!!");
            System.exit(1);
        }
        try {
            do {
                sock = serverSocket.accept();

                new SingleTCPEchoServerHybrid(sock, dataSource);
                System.out.println("Client connected");
            }
            while (true);
        } catch (IOException e) {
        e.printStackTrace();
        }
    }
}
