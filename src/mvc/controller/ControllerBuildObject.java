package mvc.controller;

import server.persistence.serverSocket.RequestDataBase;
import server.persistence.serverSocket.TypeOperation;

public class ControllerBuildObject {

    private static RequestDataBase requestDataBase;

    public static void crearObjeto(Class entity, String sql, TypeOperation typeOperation){

        if(requestDataBase == null){
            requestDataBase = new RequestDataBase(entity,sql,typeOperation);
        }
        else{
            requestDataBase.setEntity(entity);
            requestDataBase.setQuery(sql);
            requestDataBase.setOperation(typeOperation);
        }
    }
    
    public static RequestDataBase getObjetoCreado() {
        return requestDataBase;
    }

    public static void setObjeto(RequestDataBase requestDataBase) {
        ControllerBuildObject.requestDataBase = requestDataBase;
    }
}
