package mvc.controller;

import client.socket.SingleTCPEchoClientHybrid;
import server.persistence.serverSocket.RequestDataBase;
import server.persistence.serverSocket.TypeOperation;

public class ControllerBuildObject {

    private static RequestDataBase requestDataBase;

    public static void crearObjeto(Class entity, String sql, TypeOperation typeOperation){

        requestDataBase = new RequestDataBase(entity,sql,typeOperation);
        new ControllerForClient(requestDataBase);
    }
    
    public static RequestDataBase getRequestDataBase() {
        return requestDataBase;
    }

    public static void setRequestDataBase(RequestDataBase requestDataBase) {
        ControllerBuildObject.requestDataBase = requestDataBase;
    }
}
