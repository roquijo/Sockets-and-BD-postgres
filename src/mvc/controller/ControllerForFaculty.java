package mvc.controller;


import client.dao.FacultyDao;
import client.dto.FacultyDto;
import server.persistence.serverSocket.TypeOperation;


public class ControllerForFaculty {

    public ControllerForFaculty() {

        FacultyDto facultyDto = new FacultyDto();
        FacultyDao facultyDao = new FacultyDao();

        ControllerBuildObject.crearObjeto(FacultyDto.class,facultyDto.delete(), TypeOperation.DELETE);

        facultyDao.delete(facultyDto);
    }
}
