package mvc.controller;

import client.socket.SingleTCPEchoClientHybrid;
import server.persistence.serverSocket.RequestDataBase;

public  class ControllerForClient {

    private static ControllerForClient controllerForClient = null;
    private static SingleTCPEchoClientHybrid singleTCPEchoClientHybrid;

    public ControllerForClient(RequestDataBase requestDataBase)
    {
        //Crear cliente
        singleTCPEchoClientHybrid = new SingleTCPEchoClientHybrid();
        singleTCPEchoClientHybrid.setRequestDataBase(requestDataBase);
    }

    public static ControllerForClient getInstance(RequestDataBase requestDataBase)
    {
        if(controllerForClient != null)
        {
            //Set sql
            singleTCPEchoClientHybrid.setRequestDataBase(requestDataBase);
            return controllerForClient;
        }
        else
        {
            return new ControllerForClient(requestDataBase);
        }
    }

    public static void runClient()
    {
        singleTCPEchoClientHybrid.run();
    }
}
