package mvc.graphics.faculty;

import mvc.graphics.InterfaceTournament;

import javax.swing.*;
import java.awt.*;

public class FacultyPanel extends JPanel {

    private  ButtonFacultyPanel buttonFacultyPanel;
    private  FacultyInfoPanel facultyInfoPanel;
    private ImageOfFaculty imageOfFaculty;
    private InterfaceTournament principal;

    public FacultyPanel( InterfaceTournament ventana ) {

        principal = ventana;
        setLayout( new GridLayout( 1, 3 ));

        facultyInfoPanel = new FacultyInfoPanel();
        add(facultyInfoPanel);

        imageOfFaculty = new ImageOfFaculty();
        add(imageOfFaculty);

        buttonFacultyPanel = new ButtonFacultyPanel();
        add(buttonFacultyPanel);
    }
}
