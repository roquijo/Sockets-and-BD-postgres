package mvc.graphics;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPlayerPanel extends JPanel implements ActionListener {

    private static final String ADD_PLAYER = "AgregarEquipo";

    private static final String DELETE_PLAYER = "AgregarJugador";

    private static final String MODIFY_PLAYER = "CalcularNomina";

    private static final String MODIFICAR_INFORMACION_JUGADORES = "ModificarInformacionJugadores";

    private InterfaceTournament principal;

    private JButton addPlayer;

    private JButton deletePlayer;

    private JButton modifyPlayer;

    public ButtonPlayerPanel( InterfaceTournament ventana )
    {
        principal = ventana;
        setBorder( new CompoundBorder( new EmptyBorder( 5, 5, 5, 5 ), new TitledBorder( "Opciones" ) ) );
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
    }
}
