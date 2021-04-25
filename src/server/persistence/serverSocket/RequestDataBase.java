package server.persistence.serverSocket;

import java.io.Serializable;

public class RequestDataBase implements  Serializable{

    private static final long       serialVersionUID = 916582397570182364L;
    
    private  final Class entity;
    private  final String query;
    private  final TypeOperation operation;

    
    public RequestDataBase(Class entity, String query, TypeOperation operation) {
        this.entity = entity;
        this.query = query;
        this.operation = operation;
    }
    
    public  Class getEntity() {
        return entity;
    }

    public  String getQuery() {
        return query;
    }

    public  TypeOperation getOperation() {
        return operation;
    }

    @Override
    public String toString() {
        return "RequestDataBase{" +
                "entity=" + entity +
                ", query='" + query + '\'' +
                ", operation=" + operation +
                '}';
    }
}
