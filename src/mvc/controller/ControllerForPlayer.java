package mvc.controller;

import client.dao.PlayerDao;
import client.dto.FacultyDto;
import client.dto.PlayerDto;
import server.persistence.serverSocket.RequestDataBase;
import server.persistence.serverSocket.TypeOperation;


public class ControllerForPlayer {

    public static void ControllerForDeletePlayer() {

        PlayerDto playerDto = new PlayerDto(123);
        PlayerDao playerDao = new PlayerDao();

        RequestDataBase requestDataBase = new RequestDataBase(PlayerDto.class,playerDto.delete(), TypeOperation.INSERT);


        ControllerForClient.getInstance(requestDataBase);
        playerDao.delete(playerDto);
        ControllerForClient.runClient();

    }
}
