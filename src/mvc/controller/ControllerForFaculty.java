package mvc.controller;

import client.dao.FacultyDao;
import client.dto.FacultyDto;
import server.persistence.serverSocket.RequestDataBase;
import server.persistence.serverSocket.TypeOperation;

public class ControllerForFaculty {

    public ControllerForFaculty() {

        FacultyDto facultyDto = new FacultyDto(2000);
        FacultyDao facultyDao = new FacultyDao();

        facultyDao.delete(facultyDto);

        RequestDataBase requestDataBase = new RequestDataBase(facultyDto.getClass(),facultyDto.delete(), TypeOperation.DELETE);

        ControllerForClient.getInstance(requestDataBase);
        ControllerForClient.runClient();

    }
}
