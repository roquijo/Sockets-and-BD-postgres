package mvc.controller;

import client.collection.NodeList;
import client.dao.TeamDao;
import client.dto.Player;
import client.dto.Team;
import mvc.graphics.team.TeamInfoPanel;
import server.persistence.serverSocket.TypeOperation;

public class ControllerForTeam {

    private static TeamInfoPanel playerInfoPanel;



    public static void ControllerForDeleteTeam(String name) {

       Team team = new Team(name);

        
        ControllerBuildObject.crearObjeto(Team.class,team.delete(), TypeOperation.DELETE);

        ControllerForClient.getInstance(ControllerBuildObject.getObjetoCreado());
        ControllerForClient.runClient();
    }

    public static void ControllerForAddTeam(Team team) {

        ControllerBuildObject.crearObjeto(Team.class,team.insert(), TypeOperation.INSERT);

        ControllerForClient.getInstance(ControllerBuildObject.getObjetoCreado());
        ControllerForClient.runClient();

    }

    public static void ControllerForUpdateTeam(Team team){


        
        ControllerBuildObject.crearObjeto(Team.class, team.update(), TypeOperation.UPDATE);

        ControllerForClient.getInstance(ControllerBuildObject.getObjetoCreado());
        ControllerForClient.runClient();

    }

    public static NodeList<Team> ControllerForReadTeam() {

        Team TeamDto = new Team();
        TeamDao TeamDao = new TeamDao();

        return TeamDao.read(TeamDto);
    }
}
