package mvc.graphics.addFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FacultyAddFrame extends JFrame implements ActionListener {

    private static final String ADD = "Agregar";
    private static final String CANCEL = "Cancelar";
   
    private JLabel jlbIdentificador;
    private JLabel jlblNombre;
    private JLabel jlblCodigo;
    private JLabel jlblImagen;
    private JLabel jlblTitle;

    private JTextField txtIdentificador;
    private JTextField txtNombre;
    private JTextField txtCodigo;
    private JTextField txtImagen;

    private JButton btnAgregar;
    private JButton btnCancelar;

    private JPanel infoPanel;
    private JPanel btnPanel;

    public FacultyAddFrame()
    {
        setTitle("Agregar Facultad");
        setLayout(new BorderLayout());
        setSize( 350, 250 );
        setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        setLocationRelativeTo(null);
        setResizable(false);

        Font font = new Font("Arial", 2, 16);
        Font fontTxt = new Font("Arial", 2, 16);

        //Titulo
        jlblTitle = new JLabel("AGREGAR FACULTAD", SwingConstants.CENTER);
        jlblTitle.setFont(new Font("Arial", 2, 22));
        add(jlblTitle, BorderLayout.NORTH);

        //JPanel FLowLayout
        infoPanel = new JPanel();
        infoPanel.setLayout(new FlowLayout());

        add(infoPanel, BorderLayout.CENTER);

        //Info

        jlbIdentificador = new JLabel("Facultad       ");
        jlbIdentificador.setFont(font);

        jlblNombre = new JLabel("Codigo          ");
        jlblNombre.setFont(font);

        jlblCodigo = new JLabel("Identificador ");
        jlblCodigo.setFont(font);

        jlblImagen = new JLabel("Ruta Imagen");
        jlblImagen.setFont(font);

        txtIdentificador = new JTextField();
        txtIdentificador.setFont(fontTxt);
        txtIdentificador.setPreferredSize(new Dimension( 200, 30 ) );
        txtIdentificador.setEditable(true);

        txtCodigo = new JTextField();
        txtCodigo.setPreferredSize(new Dimension( 200, 30 ) );
        txtCodigo.setFont(fontTxt);
        txtCodigo.setEditable(true);

        txtNombre = new JTextField();
        txtNombre.setFont(fontTxt);
        txtNombre.setPreferredSize(new Dimension( 200, 30 ) );
        txtNombre.setEditable(true);

        txtImagen = new JTextField();
        txtImagen.setFont(fontTxt);
        txtImagen.setPreferredSize(new Dimension( 200, 30 ) );
        txtImagen.setEditable(true);

        infoPanel.add(jlbIdentificador);
        infoPanel.add(txtIdentificador);

        infoPanel.add(jlblNombre);
        infoPanel.add( txtNombre);

        infoPanel.add(jlblCodigo);
        infoPanel.add(txtCodigo);

        infoPanel.add(jlblImagen);
        infoPanel.add(txtImagen);

        //JPanel FLowLayout
        btnPanel = new JPanel();
        btnPanel.setLayout(new GridLayout(1,2));

        add(btnPanel, BorderLayout.SOUTH);

        //Botones
        btnAgregar = new JButton( "Agregar" );
        btnAgregar.setActionCommand(ADD);
        btnAgregar.addActionListener( this );

        btnCancelar = new JButton( "Cancelar" );
        btnCancelar.setActionCommand(CANCEL);
        btnCancelar.addActionListener( this );

        btnPanel.add(btnAgregar);
        btnPanel.add(btnCancelar);

    }

    @Override
    public void actionPerformed(ActionEvent evento) {

        String comando = evento.getActionCommand();

         if(ADD.equals(comando))
         {
             JOptionPane.showMessageDialog(null,"La Facultad Ha Sido Agregada");
             dispose();

         }
         else if( CANCEL.equals( comando ) )
         {
             JOptionPane.showMessageDialog(null,"Cancelado");
             dispose();
         }

    }
}
