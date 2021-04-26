package mvc.controller;

import client.collection.NodeList;
import client.dao.PlayerDao;
import client.dto.Player;
import mvc.graphics.player.PlayerInfoPanel;


public class ControllerForPlayer {

    private static PlayerInfoPanel playerInfoPanel;

    public static void ControllerForDeletePlayer(int id) {

        Player playerDto = new Player(id);
        PlayerDao playerDao = new PlayerDao();
        
        playerDao.delete(playerDto);
    }

    public static void ControllerForAddPlayer(Player playerDto) {

        PlayerDao playerDao = new PlayerDao();
        playerDao.insert(playerDto);

    }

    public static void ControllerForUpdatePlayer(Player playerDto){
        PlayerDao playerDao = new PlayerDao();
        playerDao.update(playerDto);


    }

    public static NodeList<Player> ControllerForReadPlayer() {

        Player playerDto = new Player();
        PlayerDao playerDao = new PlayerDao();

        return playerDao.read(playerDto);
    }
}
