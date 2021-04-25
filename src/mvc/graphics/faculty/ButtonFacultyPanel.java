package mvc.graphics.faculty;

import client.dto.FacultyDto;
import mvc.controller.ControllerBuildObject;
import mvc.controller.ControllerForFaculty;
import server.persistence.serverSocket.TypeOperation;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonFacultyPanel extends JPanel implements ActionListener {

    private static final String ADD_FACULTY = "AgregarFacultad";

    private static final String DELETE_FACULTY = "EliminarFacultad";

    private static final String MODIFY_FACULTY = "ModificarFacultad";

    private JButton addFaculty;

    private JButton deleteFaculty;

    private JButton modifyFaculty;

    public ButtonFacultyPanel(  )
    {
        setBorder( new CompoundBorder( new EmptyBorder(0, 0 , 20, 0 ), new TitledBorder( "Opciones" ) ) );
        setLayout( new GridLayout( 3, 1 ));

        addFaculty = new JButton( "Agregar Facultad" );
        addFaculty.setActionCommand(ADD_FACULTY);
        addFaculty.addActionListener( this );
        add(addFaculty);

        deleteFaculty = new JButton( "Eliminar Facultad" );
        deleteFaculty.setActionCommand(DELETE_FACULTY);
        deleteFaculty.addActionListener( this );
        add(deleteFaculty);

        modifyFaculty = new JButton( "Modificar Facultad" );
        modifyFaculty.setActionCommand(MODIFY_FACULTY);
        modifyFaculty.addActionListener( this );
        add(modifyFaculty);

    }

    public void actionPerformed( ActionEvent evento )
    {
        String comando = evento.getActionCommand( );

        if(ADD_FACULTY.equals(comando))
        {
            
        }
        else if( DELETE_FACULTY.equals( comando ) )
        {
            int resp = JOptionPane.showConfirmDialog(null, "Esta Seguro Que Desea Eliminar La Facultad?","Eliminar Facultad", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

            if(resp == JOptionPane.YES_OPTION)
            {
                new ControllerForFaculty();
                JOptionPane.showMessageDialog(this, "Borrado");
            }
        }
    }

}
