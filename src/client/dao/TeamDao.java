package client.dao;

import server.bdConection.DataSource;
import client.dto.Team;

public class TeamDao extends Dao<Team> {

    public TeamDao() {
        super(DataSource.getInstance());
    }
}
