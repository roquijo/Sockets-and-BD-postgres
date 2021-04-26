package mvc.controller;


import client.collection.NodeList;
import client.dao.FacultyDao;
import client.dto.Faculty;
import server.dto.FacultyDto;
import server.persistence.serverSocket.TypeOperation;


public class ControllerForFaculty {
    
     public static void ControllerForDeleteFaculty(int id) {

            Faculty faculty = new Faculty();
            faculty.setIdFaculty(id);

          ControllerBuildObject.crearObjeto(Faculty.class, faculty.delete(), TypeOperation.DELETE);

          ControllerForClient.getInstance(ControllerBuildObject.getObjetoCreado());
          ControllerForClient.runClient();
     }

     public static void ControllerForAddFaculty(Faculty faculty) {

         ControllerBuildObject.crearObjeto(Faculty.class, faculty.insert(), TypeOperation.INSERT);

         ControllerForClient.getInstance(ControllerBuildObject.getObjetoCreado());
         ControllerForClient.runClient();

     }

     public static void ControllerForUpdateFaculty(Faculty facultyDto){
         FacultyDao facultyDao = new FacultyDao();
         facultyDao.update(facultyDto);


     }

     public static NodeList<Faculty> ControllerForReadFaculty() {

         Faculty facultyDto = new Faculty();
         FacultyDao facultyDao = new FacultyDao();

         return facultyDao.read(facultyDto);
     }
}
