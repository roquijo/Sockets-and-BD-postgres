package mvc.graphics.faculty;

import mvc.graphics.InterfaceTournament;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FacultyInfoPanel extends JPanel implements ActionListener {

    private static final String CAMBIAR_FACULTAD = "CambiarFacultad";

//Mn
    private JLabel jlblFacultad;
    private JLabel jlblCodigo;
    private JLabel jlblIdentificador;

    private JComboBox comboFacultades;
    private JTextField txtCodigo;
    private JTextField txtIdentificador;

    public FacultyInfoPanel(){


        setLayout(new FlowLayout());
        Font font = new Font("Arial", 2, 18);
        Font fontTxt = new Font("Arial", 2, 16);

        jlblFacultad = new JLabel("Facultad     ");
        jlblFacultad.setFont(font);

        jlblCodigo = new JLabel("Codigo        ");
        jlblCodigo.setFont(font);

        jlblIdentificador = new JLabel("Identificador");
        jlblIdentificador.setFont(font);

        comboFacultades = new JComboBox( );
        comboFacultades.setEditable( false );
        comboFacultades.addActionListener( this );
        comboFacultades.setActionCommand(CAMBIAR_FACULTAD);
        comboFacultades.setPreferredSize( new Dimension( 195, 38 ) );

        txtCodigo = new JTextField();
        txtCodigo.setPreferredSize(new Dimension( 200, 38 ) );
        txtCodigo.setFont(fontTxt);

        txtIdentificador = new JTextField();
        txtIdentificador.setFont(fontTxt);
        txtIdentificador.setPreferredSize(new Dimension( 200, 38 ) );

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
