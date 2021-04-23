package mvc.graphics;

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

    private InterfaceTournament principal;

    private JButton addFaculty;

    private JButton deleteFaculty;

    private JButton modifyFaculty;

    public ButtonFacultyPanel( InterfaceTournament ventana )
    {
        principal = ventana;
        setBorder( new CompoundBorder( new EmptyBorder(0 , 0, 0, 0 ), new TitledBorder( "Opciones" ) ) );
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
/*
        if( ADD_FACULTY.equals( comando ) )
        {
            principal.mostrarDialogoAgregarEquipo( );
        }
        else if( DELETE_FACULTY.equals( comando ) )
        {
            principal.mostrarDialogoAgregarJugador( );
        }
        else if( MODIFY_FACULTY.equals( comando ) )
        {
            principal.calcularValorNomina( );
        }
        else if( MODIFICAR_INFORMACION_JUGADORES.equals( comando ) )
        {
            principal.modificarInformacionJugadores( );
        }
        */
    }

}
