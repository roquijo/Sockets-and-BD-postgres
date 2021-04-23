package mvc.graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeamInfoPanel extends JPanel implements ActionListener {
    private static final String CAMBIAR_EQUIPO = "CambiarEquipo";

    private InterfaceTournament principal;

    private JLabel jlblNombreEquipo;
    private JLabel jlblCapitan;
    private JLabel jlblIdentificacion;


    private JComboBox comboEquipos;
    private JTextField txtCapitan;
    private JTextField txtIdentificacion;






    public TeamInfoPanel(InterfaceTournament ventana){

        principal = ventana;

        setLayout(new GridLayout(3,3));


        jlblNombreEquipo = new JLabel("Equipo");
        jlblCapitan = new JLabel("Capitan");
        jlblIdentificacion = new JLabel("Identificacion");




        comboEquipos = new JComboBox( );
        comboEquipos.setEditable( false );
        comboEquipos.addActionListener( this );
        comboEquipos.setActionCommand( CAMBIAR_EQUIPO );
        comboEquipos.setPreferredSize( new Dimension( 230, 20 ) );

        txtIdentificacion = new JTextField();
        txtCapitan = new JTextField();
        txtIdentificacion = new JTextField();

        add(jlblNombreEquipo);
        add(comboEquipos);

        add(jlblCapitan);
        add(txtCapitan);

        add(jlblIdentificacion);
        add(txtIdentificacion);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
