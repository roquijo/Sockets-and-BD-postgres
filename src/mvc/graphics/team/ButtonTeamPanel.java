package mvc.graphics.team;

import mvc.controller.ControllerForTeam;
import mvc.graphics.InterfaceTournament;
import mvc.graphics.addFrame.TeamAddFrame;

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

    private TeamAddFrame addFrame;

    private JButton addTeam;

    private JButton deleteTeam;

    private JButton modifyTeam;

    public ButtonTeamPanel()
    {
        setBorder( new CompoundBorder( new EmptyBorder(0 , 0, 20, 0 ), new TitledBorder( "Opciones" ) ) );
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

        String comando = evento.getActionCommand( );

        if(ADD_TEAM.equals(comando))
        {
             addFrame = new TeamAddFrame();
             addFrame.setVisible(true);
        }
        else if( DELETE_TEAM.equals( comando ) )
        {
            int resp = JOptionPane.showConfirmDialog(null, "Esta Seguro Que Desea Eliminar El Equipo?","Eliminar Equipo", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

            if(resp == JOptionPane.YES_OPTION)
            {
                ControllerForTeam.ControllerForDeleteTeam(TeamInfoPanel.getNameOfTeam());
                JOptionPane.showMessageDialog(this, "Equipo eliminado");
                //TeamInfoPanel.eliminarElemento(TeamInfoPanel.getNameForDelete());
                TeamInfoPanel.limpiar();
                TeamInfoPanel.actualizarLista();
                TeamInfoPanel.llenarCombobox();
            }
        }
        else if(MODIFY_TEAM.equals(comando))
        {
            int resp = JOptionPane.showConfirmDialog(null, "Esta Seguro Que Desea Modificar El Equipo?","Modificar Equipo", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

            if(resp == JOptionPane.YES_OPTION)

            {
                TeamInfoPanel.actualizarEquipo();
                JOptionPane.showMessageDialog(this, "Equipo Actualizado");
                TeamInfoPanel.limpiar();
                TeamInfoPanel.llenarCombobox();
            }

        }
    }
}
