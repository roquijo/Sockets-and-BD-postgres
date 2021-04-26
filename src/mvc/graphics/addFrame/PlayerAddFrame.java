package mvc.graphics.addFrame;

import client.dto.PlayerDto;
import mvc.controller.ControllerForPlayer;
import mvc.graphics.player.PlayerInfoPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerAddFrame extends JFrame implements ActionListener {

    private static final String ADD = "Agregar";
    private static final String CANCEL = "Cancelar";
    private static final String CAMBIAR_EQUIPO = "CambiarEquipo";

    static PlayerDto  playerDto;

    private JLabel jlbIdentificador;
    private JLabel jlblNombre;
    private JLabel jlblPosicion;
    private JLabel jlblImagen;
    private JLabel jlblEdad;
    private JLabel jlblNombreEquipo;
    private JLabel jlblTitle;

    private JComboBox comboEquipos;

    private JTextField txtIdentificador;
    private JTextField txtNombre;
    private JTextField txtPosicion;
    private JTextField txtEdad;
    private JTextField txtNombreEquipo;
    private JTextField txtImagen;

    private JButton btnAgregar;
    private JButton btnCancelar;

    private JPanel infoPanel;
    private JPanel btnPanel;

    public PlayerAddFrame() {
        setTitle("Agregar Jugador");
        setLayout(new BorderLayout());
        setSize(350, 320);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        Font font = new Font("Arial", 2, 16);
        Font fontTxt = new Font("Arial", 2, 16);

        //Titulo
        jlblTitle = new JLabel("AGREGAR JUGADOR", SwingConstants.CENTER);
        jlblTitle.setFont(new Font("Arial", 2, 22));
        add(jlblTitle, BorderLayout.NORTH);

        //JPanel FLowLayout
        infoPanel = new JPanel();
        infoPanel.setLayout(new FlowLayout());

        add(infoPanel, BorderLayout.CENTER);

        //Info

        jlbIdentificador = new JLabel("Identificador");
        jlbIdentificador.setFont(font);

        jlblNombre = new JLabel("Nombre        ");
        jlblNombre.setFont(font);

        jlblEdad = new JLabel("Edad             ");
        jlblEdad.setFont(font);

        jlblPosicion = new JLabel("Posición       ");
        jlblPosicion.setFont(font);

        jlblNombreEquipo = new JLabel("Equipo          ");
        jlblNombreEquipo.setFont(font);

        jlblImagen = new JLabel("Ruta Imagen");
        jlblImagen.setFont(font);

        txtIdentificador = new JTextField();
        txtIdentificador.setFont(fontTxt);
        txtIdentificador.setPreferredSize(new Dimension( 200, 30 ) );
        txtIdentificador.setEditable(true);

        txtNombre = new JTextField();
        txtNombre.setFont(fontTxt);
        txtNombre.setPreferredSize(new Dimension( 200, 30 ) );
        txtNombre.setEditable(true);

        txtEdad = new JTextField();
        txtEdad.setFont(fontTxt);
        txtEdad.setPreferredSize(new Dimension( 200, 30 ) );
        txtEdad.setEditable(true);

        txtPosicion = new JTextField();
        txtPosicion.setPreferredSize(new Dimension( 200, 30 ) );
        txtPosicion.setFont(fontTxt);
        txtPosicion.setEditable(true);


        txtNombreEquipo = new JTextField();
        txtNombreEquipo.setPreferredSize(new Dimension( 200, 30 ) );
        txtNombreEquipo.setFont(fontTxt);
        txtNombreEquipo.setEditable(true);

/*
        comboEquipos = new JComboBox( );
        comboEquipos.setEditable( false );
        comboEquipos.addActionListener( this );
        //comboEquipos.setActionCommand(CAMBIAR_EQUIPO);
        comboEquipos.setPreferredSize( new Dimension( 195, 30 ) );

 */

        txtImagen = new JTextField();
        txtImagen.setFont(fontTxt);
        txtImagen.setPreferredSize(new Dimension( 200, 30 ) );
        txtImagen.setEditable(true);

        infoPanel.add(jlbIdentificador);
        infoPanel.add(txtIdentificador);

        infoPanel.add(jlblNombre);
        infoPanel.add(txtNombre);

        infoPanel.add(jlblEdad);
        infoPanel.add(txtEdad);

        infoPanel.add(jlblPosicion);
        infoPanel.add(txtPosicion);

        infoPanel.add(jlblNombreEquipo);
        infoPanel.add(txtNombreEquipo);

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

    public static PlayerDto getPlayerDto() {
        return playerDto;
    }

    public void setPlayerDto(PlayerDto playerDto) {
        this.playerDto = playerDto;
    }

    @Override
    public void actionPerformed(ActionEvent evento) {

        String comando = evento.getActionCommand();

        if(ADD.equals(comando))
        {
            System.out.println(txtNombre.getText());
            playerDto = new PlayerDto(Integer.parseInt(txtIdentificador.getText()),
            txtNombre.getText(),txtPosicion.getText(), Integer.parseInt(txtEdad.getText()), txtNombreEquipo.getText(), txtImagen.getText());
            PlayerInfoPanel.limpiar();
            PlayerInfoPanel.actualizarLista(playerDto);
            PlayerInfoPanel.llenarCombobox();
            ControllerForPlayer.ControllerForAddPlayer(playerDto);
            JOptionPane.showMessageDialog(null,"Jugador Agregado");
            dispose();

        }
        else if( CANCEL.equals( comando ) )
        {
            JOptionPane.showMessageDialog(null,"Cancelado");
            dispose();
        }
    }
}
