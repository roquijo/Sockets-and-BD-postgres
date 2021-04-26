package mvc.graphics.team;

import client.collection.NodeList;
import client.dto.Team;
import mvc.controller.ControllerForTeam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeamInfoPanel extends JPanel implements ActionListener {

    private static final String CAMBIAR_EQUIPO = "CambiarEquipo";

    private JLabel jlblNombre;
    private JLabel jlblCapitan;
    private JLabel jlblIdentificador;
    private JLabel blanco1;
    private JLabel blanco2;

    private static JComboBox comboTeam;
    private static JTextField txtCapitan;
    private static JTextField txtEdad;
    private static JTextField txtIdentificador;

    private static NodeList<Team> lista =  ControllerForTeam.ControllerForReadTeam();
    
    public TeamInfoPanel(){

        setLayout(new FlowLayout());

        Font font = new Font("Arial", 2, 16);
        Font fontTxt = new Font("Arial", 2, 16);

        blanco1 = new JLabel("                          ");
        blanco2 = new JLabel("                                             ");

        jlblNombre = new JLabel("Nombre      ");
        jlblNombre.setFont(font);

        jlblCapitan = new JLabel("Capitan       ");
        jlblCapitan.setFont(font);

        jlblIdentificador = new JLabel("Identificador");
        jlblIdentificador.setFont(font);

        comboTeam = new JComboBox( );
        comboTeam.setEditable( false );
        comboTeam.addActionListener( this );
        comboTeam.setActionCommand( CAMBIAR_EQUIPO );
        comboTeam.setPreferredSize( new Dimension( 195, 30  ) );

        txtCapitan = new JTextField();
        txtCapitan.setPreferredSize(new Dimension( 200, 30 ));
        txtCapitan.setFont(fontTxt);
        txtCapitan.setEditable(true);

        txtIdentificador = new JTextField();
        txtIdentificador.setPreferredSize(new Dimension( 200, 30 ));
        txtIdentificador.setFont(fontTxt);
        txtIdentificador.setEditable(true);

        add(blanco1);
        add(blanco2);

        add(jlblNombre);
        add(comboTeam);

        add(jlblCapitan);
        add(txtCapitan);

        add(jlblIdentificador);
        add(txtIdentificador);

        llenarCombobox();
    }

    public static void llenarCombobox() {

        for (int i = 0; i < lista.getSize(); i++) {
            comboTeam.addItem(lista.pop(i).getName());
        }
    }

    public static void limpiar(){
        comboTeam.removeAllItems();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String comando = e.getActionCommand();

        if(CAMBIAR_EQUIPO.equals(comando))
        {
            if(comboTeam.getSelectedItem() != null)
            {
                String name = comboTeam.getSelectedItem().toString();
                actualizarInfo(name);
            }
        }
    }

    public  static  void actualizarLista(Team teamDto) {

        lista.push(teamDto);
    }

    public static NodeList<Team> actualizarLista(){
       return lista =  ControllerForTeam.ControllerForReadTeam();
    }

/*
    public  static  void eliminarElemento(String name)
    {
        for (int i = 0; i < lista.getSize(); i++) {
            if(lista.pop(i).getName() == name){
                lista.remove(i);
            }
        }
    }

 */

    public static void actualizarInfo (String name) {

        boolean encontro = false;
        for (int i = 0; i < lista.getSize() && !encontro; i++) {
            if(name.equals(lista.pop(i).getName())){
               txtCapitan.setText(lista.pop(i).getCaptain());
               txtIdentificador.setText(Integer.toString(lista.pop(i).getIdFaculty()));
               encontro = true;
            }
        }
    }

    public static String getNameForDelete(){
         return comboTeam.getSelectedItem().toString();
    }
}
