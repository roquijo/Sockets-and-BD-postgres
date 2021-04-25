package mvc.controller;


import client.dao.FacultyDao;
import client.dto.FacultyDto;
import server.persistence.serverSocket.RequestDataBase;
import server.persistence.serverSocket.TypeOperation;


public class ControllerForFaculty {

    public ControllerForFaculty() {

        FacultyDto facultyDto = new FacultyDto(2000);
        FacultyDao facultyDao = new FacultyDao();

        RequestDataBase requestDataBase = new RequestDataBase(FacultyDto.class,facultyDto.delete(), TypeOperation.DELETE);

        ControllerForClient.getInstance(requestDataBase);
        ControllerForClient.runClient();
        facultyDao.delete(facultyDto);


    }
}
