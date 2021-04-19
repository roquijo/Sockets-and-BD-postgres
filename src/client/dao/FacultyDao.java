package client.dao;

import server.bdConection.DataSource;
import client.dto.FacultyDto;

public class FacultyDao extends Dao<FacultyDto> {

    public FacultyDao() {
        super(DataSource.getInstance());
    }
}
