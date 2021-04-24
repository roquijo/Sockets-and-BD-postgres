package mvc.graphics.player;

import mvc.graphics.InterfaceTournament;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerInfoPanel extends JPanel implements ActionListener {

    private static final String CAMBIAR_JUGADOR = "CambiarJugador";


    private JLabel jlblNombre;
    private JLabel jlblIdentificacion;
    private JLabel jlblEdad;
    private JLabel jlblPosicion;

    private JComboBox comboJugadores;
    private JTextField txtIdentificacion;
    private JTextField txtEdad;
    private JTextField txtPosicion;
    
    public PlayerInfoPanel(){

        setLayout(new FlowLayout());

        Font font = new Font("Arial", 2, 18);
        Font fontTxt = new Font("Arial", 2, 16);

        jlblNombre = new JLabel("Nombre       ");
        jlblNombre.setFont(font);
        
        jlblIdentificacion = new JLabel("Identificador");
        jlblIdentificacion.setFont(font);

        jlblEdad = new JLabel("Edad         ");
        jlblEdad.setFont(font);

        jlblPosicion = new JLabel("Posicion     ");
        jlblPosicion.setFont(font);


        comboJugadores = new JComboBox( );
        comboJugadores.setEditable( false );
        comboJugadores.addActionListener( this );
        comboJugadores.setActionCommand( CAMBIAR_JUGADOR );
        comboJugadores.setPreferredSize( new Dimension( 195, 38 ) );

        txtIdentificacion = new JTextField();
        txtIdentificacion.setFont(fontTxt);
        txtIdentificacion.setPreferredSize(new Dimension( 195, 38  ));

        txtEdad = new JTextField();
        txtEdad.setFont(fontTxt);
        txtEdad.setPreferredSize(new Dimension( 195, 38  ));

        txtPosicion = new JTextField();
        txtPosicion.setFont(fontTxt);
        txtPosicion.setPreferredSize(new Dimension( 195, 38  ));

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
