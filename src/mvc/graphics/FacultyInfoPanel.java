package mvc.graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FacultyInfoPanel extends JPanel implements ActionListener {

    private static final String CAMBIAR_FACULTAD = "CambiarFacultad";

    private InterfaceTournament principal;

    private JLabel jlblFacultad;
    private JLabel jlblCodigo;
    private JLabel jlblIdentificador;

    private JComboBox comboFacultades;
    private JTextField txtCodigo;
    private JTextField txtIdentificador;

    public FacultyInfoPanel(InterfaceTournament ventana){

        principal = ventana;

        setLayout(new GridLayout(3,2));

        jlblFacultad = new JLabel("Facultad");
        jlblCodigo = new JLabel("Codigo");
        jlblIdentificador = new JLabel("Identificador");

        comboFacultades = new JComboBox( );
        comboFacultades.setEditable( false );
        comboFacultades.addActionListener( this );
        comboFacultades.setActionCommand(CAMBIAR_FACULTAD);
        comboFacultades.setPreferredSize( new Dimension( 230, 20 ) );

        txtCodigo = new JTextField();
        txtIdentificador = new JTextField();

        add(jlblFacultad);
        add(comboFacultades);

        add(jlblCodigo);
        add(txtCodigo);

        add(jlblIdentificador);
        add(txtIdentificador);
        }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
