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
    private JLabel blanco1;
    private JLabel blanco2;


    private JComboBox comboFacultades;
    private JTextField txtCodigo;
    private JTextField txtIdentificador;

    public FacultyInfoPanel(){


        setLayout(new FlowLayout());
        Font font = new Font("Arial", 2, 16);
        Font fontTxt = new Font("Arial", 2, 16);

        jlblFacultad = new JLabel("Facultad     ");
        jlblFacultad.setFont(font);

        jlblCodigo = new JLabel("Codigo         ");
        jlblCodigo.setFont(font);

        jlblIdentificador = new JLabel("Identificador");
        jlblIdentificador.setFont(font);

        blanco1 = new JLabel("                          ");
        blanco2 = new JLabel("                                             ");

        comboFacultades = new JComboBox( );
        comboFacultades.setEditable( false );
        comboFacultades.addActionListener( this );
        comboFacultades.setActionCommand(CAMBIAR_FACULTAD);
        comboFacultades.setPreferredSize( new Dimension( 195, 30 ) );

        txtCodigo = new JTextField();
        txtCodigo.setPreferredSize(new Dimension( 200, 30 ) );
        txtCodigo.setFont(fontTxt);
        txtCodigo.setEditable(false);

        txtIdentificador = new JTextField();
        txtIdentificador.setFont(fontTxt);
        txtIdentificador.setPreferredSize(new Dimension( 200, 30 ) );
        txtIdentificador.setEditable(false);
        

        add(blanco1);
        add(blanco2);
        
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
