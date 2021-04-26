package mvc.graphics.player;

import mvc.controller.ControllerBuildObject;
import mvc.controller.ControllerForPlayer;
import mvc.graphics.InterfaceTournament;
import client.dto.PlayerDto;
import mvc.graphics.addFrame.PlayerAddFrame;
import mvc.graphics.addFrame.TeamAddFrame;
import server.persistence.serverSocket.TypeOperation;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPlayerPanel extends JPanel implements ActionListener {

    private static final String ADD_PLAYER = "AgregarJugador";

    private static final String DELETE_PLAYER = "EliminarJugador";

    private static final String MODIFY_PLAYER = "ModificarJugador";

    private PlayerAddFrame addFrame;

    private JButton addPlayer;

    private JButton deletePlayer;

    private JButton modifyPlayer;

    public ButtonPlayerPanel( )
    {
        setBorder( new CompoundBorder( new EmptyBorder( 0, 0, 20, 0 ), new TitledBorder( "Opciones" ) ) );
        setLayout( new GridLayout( 3, 1 ));

        addPlayer = new JButton( "Agregar Jugador" );
        addPlayer.setActionCommand(ADD_PLAYER);
        addPlayer.addActionListener( this );
        add(addPlayer);

        deletePlayer = new JButton( "Eliminar Jugador" );
        deletePlayer.setActionCommand(DELETE_PLAYER);
        deletePlayer.addActionListener( this );
        add(deletePlayer);

        modifyPlayer = new JButton( "Modificar Jugador" );
        modifyPlayer.setActionCommand(MODIFY_PLAYER);
        modifyPlayer.addActionListener( this );
        add(modifyPlayer);
    }

    public void actionPerformed( ActionEvent evento ) {

        String comando = evento.getActionCommand();
        PlayerDto playerDto = new PlayerDto();

        if(ADD_PLAYER.equals(comando))
        {
            addFrame = new PlayerAddFrame();
            addFrame.setVisible(true);
        }
        else if( DELETE_PLAYER.equals( comando ) )
        {
            int resp = JOptionPane.showConfirmDialog(null, "Esta Seguro Que Desea Eliminar el jugador?","Eliminar Jugador", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

            if(resp == JOptionPane.YES_OPTION)
            {

                ControllerForPlayer.ControllerForDeletePlayer(PlayerInfoPanel.getIdForDelete());
                JOptionPane.showMessageDialog(this, "Borrado");
                PlayerInfoPanel.eliminarElemento(PlayerInfoPanel.getIdForDelete());
                PlayerInfoPanel.llenarCombobox();
            }
        }
    }
}
