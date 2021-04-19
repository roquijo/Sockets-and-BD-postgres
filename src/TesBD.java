import client.collection.NodeList;
import client.dao.FacultyDao;
import client.dao.PlayerDao;
import client.dao.TeamDao;
import client.dto.FacultyDto;
import client.dto.PlayerDto;
import client.dto.TeamDto;

public class TesBD {

    public static void main(String[] args) {
        new TesBD();
    }

    public TesBD() {
       //Prueba read
        TeamDao teamDao = new TeamDao();
        TeamDto teamDto = new TeamDto();

        //Almacena la lista generada con los datos d ela DB
        NodeList<TeamDto> teamDtoLinkedList = new NodeList<TeamDto>();
        teamDtoLinkedList = teamDao.read(teamDto);

        System.out.printf("--------Teams------"+"\n");
        //Mostrar resultados por Consola
        for (int i = 0; i < teamDtoLinkedList.getSize(); i++) {
            System.out.println(teamDtoLinkedList.pop(i));
        }



        PlayerDao playerDao = new PlayerDao();
        PlayerDto playerDto = new PlayerDto();

        //Almacena la lista generada con los datos d ela DB
        NodeList<PlayerDto> playerDtoLinkedList = new NodeList<PlayerDto>();
        playerDtoLinkedList = playerDao.read(playerDto);
        System.out.printf("--------Players------"+"\n");
        //Mostrar resultados por Consola
        for (int i = 0; i < playerDtoLinkedList.getSize(); i++) {
            System.out.println(playerDtoLinkedList.pop(i));
        }

        FacultyDao facultyDao = new FacultyDao();
        FacultyDto facultyDto = new FacultyDto();

        //Almacena la lista generada con los datos d ela DB
        NodeList<FacultyDto> facultyDtoLinkedList = new NodeList<FacultyDto>();
        FacultyDto facultyDto1 = facultyDao.findById(facultyDto);
        System.out.printf("--------Faculty------"+"\n");

        System.out.println(facultyDto1);
        //Mostrar resultados por Consola
        /*
            for (int i = 0; i < facultyDtoLinkedList.getSize(); i++) {
            System.out.println(facultyDtoLinkedList.pop(i));
        }*/


}


}
