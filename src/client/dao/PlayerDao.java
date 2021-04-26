package client.dao;

import server.bdConection.DataSource;
import client.dto.Player;


public class PlayerDao extends Dao<Player> {

    public PlayerDao() {
        super(DataSource.getInstance());
    }
}
