
package client.dao;

import client.collection.NodeList;
import server.bdConection.DataSource;
import client.dto.Dto;
import server.bdConection.Entity;

import java.sql.ResultSet;

public abstract class Dao<T extends Dto>
{

    private final DataSource dataSource;

    protected Dao(DataSource dataSource)
    {
        this.dataSource = dataSource;
    }

    public boolean insert(Dto data)
    {
        return dataSource.runExecuteUpdate(data.insert());
    }

    public NodeList<T> read(Dto data)
    {
        Entity<T> entity = new Entity<T>(data.getClass());
        ResultSet resultSet = dataSource.runExecuteQuery(data.read());
        return entity.getMultipleRows(resultSet);
    }
    public boolean update(Dto data)
    {
        return dataSource.runExecuteUpdate(data.update());
    }

    public boolean delete(Dto data)
    {
        return dataSource.runExecuteUpdate(data.delete());
    }

    public T findById(Dto data)
    {
        Entity<T> entity = new Entity<T>(data.getClass());
        ResultSet resultSet = dataSource.runExecuteQuery(data.findById());
        return entity.getSingleRow(resultSet);
    }


}