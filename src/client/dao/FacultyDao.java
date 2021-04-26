package client.dao;

import server.bdConection.DataSource;
import client.dto.Faculty;

public class FacultyDao extends Dao<Faculty> {

    public FacultyDao() {
        super(DataSource.getInstance());
    }
}
