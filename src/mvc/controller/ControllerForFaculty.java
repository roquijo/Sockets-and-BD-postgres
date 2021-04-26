package mvc.controller;


import client.collection.NodeList;
import client.dao.FacultyDao;
import client.dto.Faculty;
import mvc.graphics.faculty.FacultyInfoPanel;


public class ControllerForFaculty {

     private static FacultyInfoPanel FacultyInfoPanel;


     public static void ControllerForDeleteFaculty(int id) {

          Faculty facultyDto = new Faculty(id);
          FacultyDao facultyDao = new FacultyDao();

          facultyDao.delete(facultyDto);
     }

     public static void ControllerForAddPlayer(Faculty facultyDto) {

          FacultyDao facultyDao = new FacultyDao();
          facultyDao.insert(facultyDto);

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
