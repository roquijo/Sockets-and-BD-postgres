package mvc.graphics;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonTeamPanel extends JPanel implements ActionListener {

    private static final String ADD_TEAM = "AgregarEquipo";

    private static final String DELETE_TEAM = "EliminarEquipo";

    private static final String MODIFY_TEAM = "ModificarEquipo";

    private InterfaceTournament principal;

    private JButton addTeam;

    private JButton deleteTeam;

    private JButton modifyTeam;

    public ButtonTeamPanel( InterfaceTournament ventana )
    {
        principal = ventana;
        setBorder( new CompoundBorder( new EmptyBorder( 5, 5, 5, 5 ), new TitledBorder( "Opciones" ) ) );
        setLayout( new GridLayout( 3, 1 ));

        addTeam = new JButton( "Agregar Equipo" );
        addTeam.setActionCommand(ADD_TEAM);
        addTeam.addActionListener( this );
        add(addTeam);

        deleteTeam = new JButton( "Eliminar Equipo" );
        deleteTeam.setActionCommand(DELETE_TEAM);
        deleteTeam.addActionListener( this );
        add(deleteTeam);

        modifyTeam = new JButton( "Modificar Equipo" );
        modifyTeam.setActionCommand(MODIFY_TEAM);
        modifyTeam.addActionListener( this );
        add(modifyTeam);

    }

    public void actionPerformed( ActionEvent evento ) {
        String comando = evento.getActionCommand();
    }
}
