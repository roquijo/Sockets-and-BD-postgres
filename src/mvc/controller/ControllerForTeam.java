package mvc.controller;

import client.collection.NodeList;
import client.dao.TeamDao;
import client.dto.Team;
import mvc.graphics.team.TeamInfoPanel;

public class ControllerForTeam {

    private static TeamInfoPanel playerInfoPanel;

    public static void ControllerForDeleteTeam(String name) {

        Team teamDto = new Team(name);
        TeamDao teamDao = new TeamDao();

        teamDao.delete(teamDto);
    }

    public static void ControllerForAddTeam(Team playerDto) {

        TeamDao teamDao = new TeamDao();
        teamDao.insert(playerDto);

    }

    public static void ControllerForUpdateTeam(Team teamDto){
        TeamDao teamDao = new TeamDao();
        teamDao.update(teamDto);


    }

    public static NodeList<Team> ControllerForReadTeam() {

        Team TeamDto = new Team();
        TeamDao TeamDao = new TeamDao();

        return TeamDao.read(TeamDto);
    }
}
