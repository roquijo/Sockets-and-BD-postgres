package server;

import client.dao.PlayerDao;
import client.dto.Player;

public class Test {

    public static void main(String[] args) {
        new Test();
    }


    public Test() {
/**
            FacultyDto facultyDto = new FacultyDto(2000,
                "Facultad de Ing",
                "20",
                "imagenes/facultades/facultadIngenieria.png");

        FacultyDao facultyDao = new FacultyDao();
        facultyDao.insert(facultyDto)
 **/



        //Equipo

/**
        TeamDto teamDto = new TeamDto("America",
                        "falcao",
                        "src/world.mvc.Client.mvc.controller.imagenes/equipos/losCincoFantasticos.png",
                        3000);
        TeamDao teamDao = new TeamDao();
        teamDao.insert(teamDto);
 **/



/*
        //Player
        LinkedList<PlayerDto> personList = new LinkedList<>();(
                new PlayerDto(123,
                        "Barbara",
                        "Liskov",
                        15,
                        "deportes tolima",
                        "src/world.mvc.Client.mvc.controller.imagenes/equipos/laMafiaRusa.png"),
                new PlayerDto(456,
                        "Jorge",
                        "Rojas",
                        16,
                        "deportes tolima",
                        "src/world.mvc.Client.mvc.controller.imagenes/equipos/laMafiaRusa.png"),
                new PlayerDto(789,
                        "Juan pablo",
                        "Meneses",
                        17,
                        "deportes tolima",
                        "\"src/world.mvc.Client.mvc.controller.imagenes/equipos/laMafiaRusa.png\""),
                new PlayerDto(147,
                        "Juanes",
                        "Gomez",
                        18,
                        "deportes tolima",
                        "\"src/world.mvc.Client.mvc.controller.imagenes/equipos/laMafiaRusa.png\""),
                new PlayerDto(258,
                        "Prueba",
                        "asda",
                        19,
                        "deportes tolima",
                        "\"src/world.mvc.Client.mvc.controller.imagenes/equipos/laMafiaRusa.png\"")
        );

        PlayerDao personaDao = new PlayerDao();
        personList.forEach(person -> {
            personaDao.insert(person);
        });
        PlayerDao player = new PlayerDao();
        personList = player.read();
        personList.forEach(System.out::println);
*/

        Player playerDto = new Player(180,
                "Juan Lopéz",
                "Delantero",
                55,
                "America",
                "src/world.mvc.Client.mvc.controller.imagenes/equipos/laMafiaRusa.png");
        PlayerDao playerDao = new PlayerDao();
        playerDao.insert(playerDto);




    }
}
