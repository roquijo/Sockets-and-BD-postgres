import client.collection.NodeList;
import client.dao.FacultyDao;
import client.dao.PlayerDao;
import client.dao.TeamDao;
import client.dto.Faculty;
import client.dto.Player;
import client.dto.Team;
import server.dto.FacultyDto;

public class TesBD {

    public static void main(String[] args) {
        new TesBD();
    }

    public TesBD() {
       //Prueba read
        TeamDao teamDao = new TeamDao();
        Team teamDto = new Team();

        //Almacena la lista generada con los datos d ela DB
        NodeList<Team> teamDtoLinkedList = new NodeList<Team>();
        teamDtoLinkedList = teamDao.read(teamDto);

        System.out.printf("--------Teams------"+"\n");
        //Mostrar resultados por Consola
        for (int i = 0; i < teamDtoLinkedList.getSize(); i++) {
            System.out.println(teamDtoLinkedList.pop(i));
        }



        PlayerDao playerDao = new PlayerDao();
        Player playerDto = new Player();

        //Almacena la lista generada con los datos d ela DB
        NodeList<Player> playerDtoLinkedList = new NodeList<Player>();
        playerDtoLinkedList = playerDao.read(playerDto);
        System.out.printf("--------Players------"+"\n");
        //Mostrar resultados por Consola
        for (int i = 0; i < playerDtoLinkedList.getSize(); i++) {
            System.out.println(playerDtoLinkedList.pop(i));
        }

        FacultyDao facultyDao = new FacultyDao();
        Faculty facultyDto = new Faculty();

        //Almacena la lista generada con los datos d ela DB
        NodeList<Faculty> facultyDtoLinkedList = new NodeList<Faculty>();
        Faculty facultyDto1 = facultyDao.findById(facultyDto);
        System.out.printf("--------Faculty------"+"\n");

        System.out.println(facultyDto1);
        //Mostrar resultados por Consola
        /*
            for (int i = 0; i < facultyDtoLinkedList.getSize(); i++) {
            System.out.println(facultyDtoLinkedList.pop(i));
        }*/


}


}
