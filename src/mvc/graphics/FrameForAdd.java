package mvc.graphics;

import javax.swing.*;
import java.awt.*;

public class FrameForAdd extends JFrame {

    private static final String ADD = "Agregar";

    private static final String CANCEL = "cancelar";
   
    private JLabel jlbIdentificador;
    private JLabel jlblNombre;
    private JLabel jlblCodigo;
    private JLabel jlblImagen;

    private JTextField txtIdentificador;
    private JTextField txtNombre;
    private JTextField txtCodigo;
    private JTextField txtImagen;

    private JButton btnAgregar;
    private JButton btnCancelar;


    public FrameForAdd()
    {
        setTitle("Agregar Facultad");
        setLayout(new BorderLayout());
        setSize( 400, 600 );
        setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        setLocationRelativeTo(null);
        setResizable(false);

        Font font = new Font("Arial", 2, 16);
        Font fontTxt = new Font("Arial", 2, 16);

        jlbIdentificador = new JLabel("Facultad     ");
        jlbIdentificador.setFont(font);

        jlblNombre = new JLabel("Codigo         ");
        jlblNombre.setFont(font);

        jlblCodigo = new JLabel("Identificador");
        jlblCodigo.setFont(font);

        jlblImagen = new JLabel("Identificador");
        jlblImagen.setFont(font);

        txtIdentificador = new JTextField();
        txtIdentificador.setFont(fontTxt);
        txtIdentificador.setPreferredSize(new Dimension( 200, 30 ) );
        txtIdentificador.setEditable(false);
        txtCodigo = new JTextField();
        txtCodigo.setPreferredSize(new Dimension( 200, 30 ) );
        txtCodigo.setFont(fontTxt);
        txtCodigo.setEditable(false);

        txtNombre = new JTextField();
        txtNombre.setFont(fontTxt);
        txtNombre.setPreferredSize(new Dimension( 200, 30 ) );
        txtNombre.setEditable(false);

        txtImagen = new JTextField();
        txtImagen.setFont(fontTxt);
        txtImagen.setPreferredSize(new Dimension( 200, 30 ) );
        txtImagen.setEditable(false);

        btnAgregar = new JButton( "Agregar" );
        btnAgregar.setActionCommand(ADD);
        //btnAgregar.addActionListener( this );

        btnCancelar = new JButton( "Cancelar" );
         btnCancelar.setActionCommand(CANCEL);



        add(jlbIdentificador);
        add(txtIdentificador);

        add(jlblNombre);
        add( txtNombre);

        add(jlblCodigo);
        add(txtCodigo);

        add(jlblImagen);
        add(txtImagen);


    }


}
