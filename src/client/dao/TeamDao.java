package client.dao;

import server.bdConection.DataSource;
import client.dto.TeamDto;

public class TeamDao extends Dao<TeamDto> {

    public TeamDao() {
        super(DataSource.getInstance());
    }
}
