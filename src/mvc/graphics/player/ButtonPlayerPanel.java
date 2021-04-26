package mvc.graphics.player;

import mvc.controller.ControllerForPlayer;
import client.dto.Player;
import mvc.graphics.addFrame.PlayerAddFrame;

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

    static Player player;

    private PlayerAddFrame addFrame;

    private PlayerInfoPanel playerInfo;

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
        Player playerDto = new Player();

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
                PlayerInfoPanel.actualizarLista();
                PlayerInfoPanel.limpiar();
                PlayerInfoPanel.llenarCombobox();
            }
        }
        else if( MODIFY_PLAYER.equals( comando ) )
        {
            int resp = JOptionPane.showConfirmDialog(null, "Esta Seguro Que Desea Modificar el jugador?","Modificar Jugador", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

            if(resp == JOptionPane.YES_OPTION)

            {

                PlayerInfoPanel.actualizarJugador();
                JOptionPane.showMessageDialog(this, "Jugador Actualizado");
                PlayerInfoPanel.limpiar();
                PlayerInfoPanel.llenarCombobox();

            }
        }
    }
}
