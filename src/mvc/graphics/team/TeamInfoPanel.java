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

        setLayout(new FlowLayout());

        Font font = new Font("Arial", 2, 18);
        Font fontTxt = new Font("Arial", 2, 16);

        jlblNombre = new JLabel("Nombre      ");
        jlblNombre.setFont(font);

        jlblCapitan = new JLabel("Capitan       ");
        jlblCapitan.setFont(font);

        jlblIdentificador = new JLabel("Identificador");
        jlblIdentificador.setFont(font);

        comboJugadores = new JComboBox( );
        comboJugadores.setEditable( false );
        comboJugadores.addActionListener( this );
        comboJugadores.setActionCommand( CAMBIAR_JUGADOR );
        comboJugadores.setPreferredSize( new Dimension( 195, 38  ) );

        txtCapitan = new JTextField();
        txtCapitan.setPreferredSize(new Dimension( 200, 38 ));
        txtCapitan.setFont(fontTxt);


        txtIdentificador = new JTextField();
        txtIdentificador.setPreferredSize(new Dimension( 200, 38 ));
        txtIdentificador.setFont(fontTxt);

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
