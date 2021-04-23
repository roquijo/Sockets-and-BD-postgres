package mvc.graphics.team;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeamInfoPanel extends JPanel implements ActionListener {

    private static final String CAMBIAR_JUGADOR = "CambiarJugador";


    private JLabel jlblNombre;
    private JLabel jlblCapitan;
    private JLabel jlblIdentificador;


    private JComboBox comboJugadores;
    private JTextField txtIdentificacion;
    private JTextField txtEdad;
    private JTextField txtPosicion;
    
    public TeamInfoPanel(){

        setLayout(new GridLayout(3,2));

        jlblNombre = new JLabel("Nombre");
        jlblNombre.setFont(new Font(jlblNombre.getName(), Font.PLAIN, 18));

        jlblCapitan = new JLabel("Capitan");
        jlblCapitan.setFont(new Font(jlblCapitan.getName(), Font.PLAIN, 18));

        jlblIdentificador = new JLabel("Identificador");
        jlblIdentificador.setFont(new Font(jlblIdentificador.getName(), Font.PLAIN, 18));

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
