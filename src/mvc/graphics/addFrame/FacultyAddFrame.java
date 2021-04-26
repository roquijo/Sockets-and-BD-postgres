package mvc.graphics.addFrame;

import client.dto.Faculty;
import client.dto.Player;
import mvc.controller.ControllerForFaculty;
import mvc.controller.ControllerForPlayer;
import mvc.graphics.faculty.FacultyInfoPanel;
import mvc.graphics.player.PlayerInfoPanel;
import server.dto.FacultyDto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FacultyAddFrame extends JFrame implements ActionListener {

    static Faculty faculty;
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
    private static JTextField txtImagen;

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
        //Info x2
        jlbIdentificador = new JLabel("Identificador ");
        jlbIdentificador.setFont(font);

        jlblNombre = new JLabel("Facultad       ");
        jlblNombre.setFont(font);

        jlblCodigo = new JLabel("Codigo          ");
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
             faculty = new Faculty(Integer.parseInt(txtIdentificador.getText()),
                     txtNombre.getText(),txtCodigo.getText(), txtImagen.getText());
             System.out.println(faculty.toString());
             FacultyInfoPanel.limpiar();
             FacultyInfoPanel.agregarALista(faculty);
             FacultyInfoPanel.llenarCombobox();
             ControllerForFaculty.ControllerForAddFaculty(faculty);
             JOptionPane.showMessageDialog(null,"La Facultad Ha Sido Agregada");
             dispose();

         }
         else if( CANCEL.equals( comando ) )
         {
             JOptionPane.showMessageDialog(null,"Cancelado");
             dispose();
         }

    }

    public static String getRuta(){
        if(txtImagen != null){
            return txtImagen.getText();
        }
       return  null;
    }
}
