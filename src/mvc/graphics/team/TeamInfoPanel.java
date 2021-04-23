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
    private JTextField txtCapitan;
    private JTextField txtEdad;
    private JTextField txtIdentificador;
    
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

        txtCapitan = new JTextField();
        txtEdad = new JTextField();
        txtIdentificador = new JTextField();

        add(jlblNombre);
        add(comboJugadores);

        add(jlblCapitan);
        add(txtCapitan);

        add(jlblIdentificador);
        add(txtIdentificador);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
