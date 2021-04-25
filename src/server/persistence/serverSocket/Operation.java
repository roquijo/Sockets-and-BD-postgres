package server.persistence.serverSocket;

import client.collection.NodeList;
import client.dto.Dto;
import server.bdConection.DataSource;
import server.bdConection.Entity;

public class Operation {

    public static Object doOperation(RequestDataBase requestDataBase, Entity entity){

        if(requestDataBase.getOperation().equals(TypeOperation.SELECT)){
            NodeList<Dto> list =  entity.getMultipleRows(DataSource.getInstance().runExecuteQuery(requestDataBase.getQuery()));
            return list;
        }
        else if(requestDataBase.getOperation().equals(TypeOperation.FIND_ID)) {
            Dto object = entity.getSingleRow(DataSource.getInstance().runExecuteQuery(requestDataBase.getQuery()));
            return object;
        }
        else  if(requestDataBase.getOperation().equals(TypeOperation.EXIT)) {
            return null;
        }
        else{
            boolean answer = DataSource.getInstance().runExecuteUpdate(requestDataBase.getQuery());
            return  answer;
        }
    }
}
