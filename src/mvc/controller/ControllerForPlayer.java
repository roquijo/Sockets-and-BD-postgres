package mvc.controller;

import client.collection.NodeList;
import client.dao.PlayerDao;
import client.dto.PlayerDto;
import mvc.graphics.player.PlayerInfoPanel;


public class ControllerForPlayer {
    private static PlayerInfoPanel playerInfoPanel;

    public static void ControllerForDeletePlayer(int id) {

        PlayerDto playerDto = new PlayerDto(id);
        PlayerDao playerDao = new PlayerDao();
        
        playerDao.delete(playerDto);
    }

    public static void ControllerForAddPlayer(PlayerDto playerDto) {

        PlayerDao playerDao = new PlayerDao();
        playerDao.insert(playerDto);

    }

    public static void ControllerForUpdatePlayer(){

    }

    public static NodeList<PlayerDto> ControllerForReadPlayer() {

        PlayerDto playerDto = new PlayerDto();
        PlayerDao playerDao = new PlayerDao();

        return playerDao.read(playerDto);
    }
}
