package server.persistence.serverSocket;

public class RequestDataBase {
    
    private final Class entity;
    private final String query;
    private final TypeOperation operation;

    public RequestDataBase(Class entity, String query, TypeOperation operation) {
        this.entity = entity;
        this.query = query;
        this.operation = operation;
    }

    public Class getEntity() {
        return entity;
    }

    public String getQuery() {
        return query;
    }

    public TypeOperation getOperation() {
        return operation;
    }
}
