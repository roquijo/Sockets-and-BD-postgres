package mvc.graphics.faculty;

import mvc.graphics.InterfaceTournament;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FacultyInfoPanel extends JPanel implements ActionListener {

    private static final String CAMBIAR_FACULTAD = "CambiarFacultad";


    private JLabel jlblFacultad;
    private JLabel jlblCodigo;
    private JLabel jlblIdentificador;

    private JComboBox comboFacultades;
    private JTextField txtCodigo;
    private JTextField txtIdentificador;

    public FacultyInfoPanel(){

        setLayout(new GridLayout(3,2));

        jlblFacultad = new JLabel("Facultad");
        jlblFacultad.setFont(new Font(jlblFacultad.getName(), Font.PLAIN, 18));

        jlblCodigo = new JLabel("Codigo");
        jlblCodigo.setFont(new Font(jlblFacultad.getName(), Font.PLAIN, 18));

        jlblIdentificador = new JLabel("Identificador");
        jlblIdentificador.setFont(new Font(jlblFacultad.getName(), Font.PLAIN, 18));

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
