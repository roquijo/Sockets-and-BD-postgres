package client.dao;

import server.bdConection.DataSource;
import client.dto.Faculty;
import server.dto.FacultyDto;

public class FacultyDao extends Dao<Faculty> {

    public FacultyDao() {
        super(DataSource.getInstance());
    }
}
