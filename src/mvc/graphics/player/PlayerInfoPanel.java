package mvc.graphics.player;

import client.collection.NodeList;
import client.dto.Player;
import mvc.controller.ControllerForPlayer;
import mvc.graphics.faculty.FacultyInfoPanel;
import mvc.graphics.team.TeamInfoPanel;

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

    private static ImageOfPlayer image;


    private static JComboBox comboJugadores;
    private static JTextField txtIdentificacion;
    private static JTextField txtEdad;
    private static JTextField txtPosicion;

    private static NodeList<Player> lista =  ControllerForPlayer.ControllerForReadPlayer();
    
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

        if(comboJugadores != null){
            limpiar();
            for (int i = 0; i < lista.getSize(); i++) {
                if(lista.pop(i).getNameOfTeam().equals(TeamInfoPanel.getNameOfTeam())){
                    comboJugadores.addItem(lista.pop(i).getName());
                }
            }
        }
    }
    
    public static NodeList<Player> actualizarLista(){
       return lista =  ControllerForPlayer.ControllerForReadPlayer();
    }

    public static void limpiar(){
        comboJugadores.removeAllItems();
        txtEdad.setText("");
        txtPosicion.setText("");
        txtIdentificacion.setText("");
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

    public static void actualizarJugador()
    {
        Player playerM = new Player(Integer.parseInt(txtIdentificacion.getText()), comboJugadores.getSelectedItem().toString(),
                txtPosicion.getText(), Integer.parseInt(txtEdad.getText()),"team", "image");
        for (int i = 0; i < lista.getSize(); i++) {
            if(lista.pop(i).getName().equals(comboJugadores.getSelectedItem().toString())){
                lista.pop(i).setAge(Integer.parseInt(txtEdad.getText()));
                lista.pop(i).setPosition(txtPosicion.getText());
            }
        }
        ControllerForPlayer.ControllerForUpdatePlayer(playerM);
    }

    public  static  void agregarALista(Player playerDto) {
        lista.push(playerDto);
    }

    public  static  void eliminarElemento(int id)
    {
        for (int i = 0; i < lista.getSize(); i++) {
            if(lista.pop(i).getIdPlayer() == id){
                lista.remove(i);
            }
        }
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
