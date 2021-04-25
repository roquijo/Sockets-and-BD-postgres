package mvc.controller;

import client.dao.PlayerDao;
import client.dto.FacultyDto;
import client.dto.PlayerDto;
import server.persistence.serverSocket.RequestDataBase;
import server.persistence.serverSocket.TypeOperation;


public class ControllerForPlayer {

    public static void ControllerForDeletePlayer() {

        PlayerDto playerDto = new PlayerDto();
        PlayerDao playerDao = new PlayerDao();

        RequestDataBase requestDataBase = new RequestDataBase(PlayerDto.class,playerDto.delete(), TypeOperation.DELETE);

        ControllerForClient.getInstance(requestDataBase);
        playerDao.delete(playerDto);
        ControllerForClient.runClient();
    }

    public static void ControllerForAddPlayer(PlayerDto playerDto) {

        PlayerDao playerDao = new PlayerDao();

        RequestDataBase requestDataBase = new RequestDataBase(PlayerDto.class,playerDto.insert(), TypeOperation.INSERT);

        ControllerForClient.getInstance(requestDataBase);
        playerDao.insert(playerDto);
        ControllerForClient.runClient();
    }

    public static void ControllerForReadPlayer() {

        PlayerDto playerDto = new PlayerDto();
        PlayerDao playerDao = new PlayerDao();

        RequestDataBase requestDataBase = new RequestDataBase(PlayerDto.class,playerDto.read(), TypeOperation.SELECT);

        ControllerForClient.getInstance(requestDataBase);
        playerDao.read(playerDto);
        ControllerForClient.runClient();
    }
}
