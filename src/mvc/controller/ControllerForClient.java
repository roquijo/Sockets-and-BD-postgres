package mvc.controller;

import client.collection.NodeList;
import client.socket.SingleTCPEchoClientHybrid;
import server.dto.Dto;
import server.persistence.serverSocket.RequestDataBase;

public  class ControllerForClient {

    private static ControllerForClient controllerForClient = null;
    private static SingleTCPEchoClientHybrid singleTCPEchoClientHybrid = null;

    private ControllerForClient(RequestDataBase requestDataBase)
    {
        singleTCPEchoClientHybrid = new SingleTCPEchoClientHybrid();
        singleTCPEchoClientHybrid.setRequestDataBase(requestDataBase);
    }

    public static ControllerForClient getInstance(RequestDataBase requestDataBase)
    {
        if(controllerForClient != null)
        {
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

    public static NodeList<Dto> darLista(){
       return singleTCPEchoClientHybrid.getLista();


    }
}
