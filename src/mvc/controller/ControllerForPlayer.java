package mvc.controller;

import client.collection.NodeList;
import client.dao.FacultyDao;
import client.dao.PlayerDao;
import client.dto.Faculty;
import client.dto.Player;
import mvc.graphics.player.PlayerInfoPanel;
import server.dto.Dto;
import server.dto.PlayerDto;
import server.persistence.serverSocket.TypeOperation;


public class ControllerForPlayer {

    private static PlayerInfoPanel playerInfoPanel;

   // private static Player playerDto = new Player();

    public static void ControllerForDeletePlayer(int id) {

        Player playerDto = new Player(id);

        ControllerBuildObject.crearObjeto(Player.class, playerDto.delete(), TypeOperation.DELETE);

        ControllerForClient.getInstance(ControllerBuildObject.getObjetoCreado());
        ControllerForClient.runClient();
    }

    public static void ControllerForAddPlayer(Player player) {

        ControllerBuildObject.crearObjeto(Player.class,player.insert(), TypeOperation.INSERT);

        ControllerForClient.getInstance(ControllerBuildObject.getObjetoCreado());
        ControllerForClient.runClient();

    }

    public static void ControllerForUpdatePlayer(Player player){

        ControllerBuildObject.crearObjeto(Player.class,player.update(), TypeOperation.UPDATE);

        ControllerForClient.getInstance(ControllerBuildObject.getObjetoCreado());
        ControllerForClient.runClient();
    }

    public static NodeList<Player> ControllerForReadPlayer() {

/*
        ControllerBuildObject.crearObjeto(Player.class,playerDto.read(), TypeOperation.SELECT);

        ControllerForClient.getInstance(ControllerBuildObject.getObjetoCreado());
        ControllerForClient.runClient();
        //NodeList<Player> lista = ControllerForClient.darLista();

        return  null;

 */
        Player player = new Player();
        PlayerDao playerDao = new PlayerDao();

        return playerDao.read(player);
    }
}
