package client.dao;

import server.bdConection.DataSource;
import client.dto.PlayerDto;


public class PlayerDao extends Dao<PlayerDto> {

    public PlayerDao() {
        super(DataSource.getInstance());
    }
}
