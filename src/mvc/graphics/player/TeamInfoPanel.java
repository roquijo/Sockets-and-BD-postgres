package mvc.graphics.player;

import mvc.graphics.InterfaceTournament;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeamInfoPanel extends JPanel implements ActionListener {

    private static final String CAMBIAR_JUGADOR = "CambiarJugador";


    private JLabel jlblNombre;
    private JLabel jlblIdentificacion;
    private JLabel jlblEdad;
    private JLabel jlblPosicion;

    private JComboBox comboJugadores;
    private JTextField txtIdentificacion;
    private JTextField txtEdad;
    private JTextField txtPosicion;
    
    public TeamInfoPanel(){

        setLayout(new GridLayout(4,2));

        jlblNombre = new JLabel("Nombre");
        jlblIdentificacion = new JLabel("Identificacion");
        jlblEdad = new JLabel("Edad");
        jlblPosicion = new JLabel("Posicion");

        comboJugadores = new JComboBox( );
        comboJugadores.setEditable( false );
        comboJugadores.addActionListener( this );
        comboJugadores.setActionCommand( CAMBIAR_JUGADOR );
        comboJugadores.setPreferredSize( new Dimension( 230, 20 ) );

        txtIdentificacion = new JTextField();
        txtEdad = new JTextField();
        txtPosicion = new JTextField();

        add(jlblNombre);
        add(comboJugadores);

        add(jlblIdentificacion);
        add(txtIdentificacion);

        add(jlblEdad);
        add(txtEdad);

        add(jlblPosicion);
        add(txtPosicion);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
