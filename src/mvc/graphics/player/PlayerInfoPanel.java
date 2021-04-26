package mvc.graphics.player;

import client.collection.NodeList;
import client.dto.FacultyDto;
import client.dto.PlayerDto;
import client.socket.SingleTCPEchoClientHybrid;
import mvc.controller.ControllerForPlayer;
import mvc.graphics.InterfaceTournament;
import mvc.graphics.addFrame.PlayerAddFrame;
import server.dto.Dto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerInfoPanel extends JPanel implements ActionListener {

    private static final String CAMBIAR_JUGADOR = "CambiarJugador";


    private JLabel jlblNombre;
    private JLabel jlblIdentificacion;
    private JLabel jlblEdad;
    private JLabel jlblPosicion;

    private static JComboBox comboJugadores;
    private static JTextField txtIdentificacion;
    private static JTextField txtEdad;
    private static JTextField txtPosicion;

    private static NodeList<PlayerDto> lista =  ControllerForPlayer.ControllerForReadPlayer();
    
    public PlayerInfoPanel(){

        setLayout(new FlowLayout());

        Font font = new Font("Arial", 2, 16);
        Font fontTxt = new Font("Arial", 2, 14);

        jlblNombre = new JLabel("Nombre       ");
        jlblNombre.setFont(font);
        
        jlblIdentificacion = new JLabel("Identificador");
        jlblIdentificacion.setFont(font);

        jlblEdad = new JLabel("Edad            ");
        jlblEdad.setFont(font);

        jlblPosicion = new JLabel("Posicion      ");
        jlblPosicion.setFont(font);
        
        comboJugadores = new JComboBox( );
        comboJugadores.setEditable( false );
        comboJugadores.addActionListener( this );
        comboJugadores.setActionCommand( CAMBIAR_JUGADOR );
        comboJugadores.setPreferredSize( new Dimension( 195, 27 ) );

        txtIdentificacion = new JTextField();
        txtIdentificacion.setFont(fontTxt);
        txtIdentificacion.setPreferredSize(new Dimension( 195, 27  ));
        txtIdentificacion.setEditable(false);

        txtEdad = new JTextField();
        txtEdad.setFont(fontTxt);
        txtEdad.setPreferredSize(new Dimension( 195, 27 ));
        txtEdad.setEditable(true);

        txtPosicion = new JTextField();
        txtPosicion.setFont(fontTxt);
        txtPosicion.setPreferredSize(new Dimension( 195, 27  ));
        txtPosicion.setEditable(true);

        add(jlblNombre);
        add(comboJugadores);

        add(jlblIdentificacion);
        add(txtIdentificacion);

        add(jlblEdad);
        add(txtEdad);

        add(jlblPosicion);
        add(txtPosicion);

        llenarCombobox();
    }

    public static void llenarCombobox() {

        for (int i = 0; i < lista.getSize(); i++) {
            comboJugadores.addItem(lista.pop(i).getName());
        }
    }

    public static void limpiar(){
        comboJugadores.removeAllItems();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String comando = e.getActionCommand();
        
        if(CAMBIAR_JUGADOR.equals(comando))
        {
            if(comboJugadores.getSelectedItem() != null)
            {
                String name = comboJugadores.getSelectedItem().toString();
                actualizarInfo(name);
            }


        }
    }

    public  static  void actualizarLista(PlayerDto playerDto) {

        lista.push(playerDto);
    }

    public static void actualizarInfo (String name) {

        boolean encontro = false;
        for (int i = 0; i < lista.getSize() && !encontro; i++) {
            if(name.equals(lista.pop(i).getName())){
                txtEdad.setText(Integer.toString(lista.pop(i).getAge()));
                txtIdentificacion.setText(Integer.toString(lista.pop(i).getIdPlayer()));
                txtPosicion.setText(lista.pop(i).getPosition());
                encontro = true;
            }
        }
    }

    public static int getIdForDelete(){
         return Integer.parseInt(txtIdentificacion.getText());
    }
}
