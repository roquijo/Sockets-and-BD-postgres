package mvc.graphics.faculty;

import client.collection.NodeList;
import client.dto.Faculty;
import client.dto.Player;
import client.dto.Team;
import mvc.controller.ControllerForFaculty;
import mvc.controller.ControllerForPlayer;
import mvc.controller.ControllerForTeam;
import mvc.graphics.addFrame.FacultyAddFrame;
import mvc.graphics.team.TeamInfoPanel;
import server.dto.FacultyDto;

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


    private static JComboBox comboFacultades;
    private static JTextField txtCodigo;
    private static JTextField txtIdentificador;
    private static NodeList<Faculty> lista = ControllerForFaculty.ControllerForReadFaculty();

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
        txtCodigo.setEditable(true);

        txtIdentificador = new JTextField();
        txtIdentificador.setFont(fontTxt);
        txtIdentificador.setPreferredSize(new Dimension( 200, 30 ) );
        txtIdentificador.setEditable(false);
        Faculty facultyDto = new Faculty();
        facultyDto.setIdFaculty(2000);



        add(blanco1);
        add(blanco2);
        
        add(jlblFacultad);
        add(comboFacultades);

        add(jlblCodigo);
        add(txtCodigo);

        add(jlblIdentificador);
        add(txtIdentificador);

        llenarCombobox();


        }

    public  static  void agregarALista(Faculty faculty) {

        lista.push(faculty);
    }

    public static void llenarCombobox() {

        if(!lista.isEmpty()){
            for (int i = 0; i < lista.getSize(); i++) {
                comboFacultades.addItem(lista.pop(i).getName());
            }
        }
    }

    public static void limpiar(){
        comboFacultades.removeAllItems();
        txtCodigo.setText("");
        txtIdentificador.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String comando = e.getActionCommand();

        if(CAMBIAR_FACULTAD.equals(comando))
        {
            if(comboFacultades.getSelectedItem() != null)
            {
                String name = comboFacultades.getSelectedItem().toString();
                actualizarInfo(name);
                ImageOfFaculty.setRuta(obtenerRuta());
                ImageOfFaculty.actualizarImagen();
                TeamInfoPanel.llenarCombobox();
            }
        }
    }

    public String obtenerRuta() {
        String ruta = null;

        if (comboFacultades.getSelectedItem() != null) {
            String name = comboFacultades.getSelectedItem().toString();

            for (int i = 0; i < lista.getSize(); i++) {
                if (lista.pop(i).getName() == name){
                    ruta = lista.pop(i).getImageFaculty();
                }
            }
        }
        return  ruta;
    }
    public static void actualizarFacultad()
    {
        Faculty facultyM = new Faculty(Integer.parseInt(txtIdentificador.getText()),comboFacultades.getSelectedItem().toString(),txtCodigo.getText(), "image");
        for (int i = 0; i < lista.getSize(); i++) {
            if(lista.pop(i).getName().equals(comboFacultades.getSelectedItem().toString())){
                lista.pop(i).setCode(txtCodigo.getText());
            }
        }
        ControllerForFaculty.ControllerForUpdateFaculty(facultyM);
    }
    ///ComentarioOOOOO

    public static NodeList<Faculty> actualizarLista(){
        return lista =  ControllerForFaculty.ControllerForReadFaculty();
    }

    public static void actualizarInfo (String name) {

        boolean encontro = false;
        for (int i = 0; i < lista.getSize() && !encontro; i++) {
            if(name.equals(lista.pop(i).getName())){
                txtIdentificador.setText(Integer.toString(lista.pop(i).getIdFaculty()));
                txtCodigo.setText(lista.pop(i).getCode());
                encontro = true;
            }
        }
    }

    public static int getId(){
        return Integer.parseInt(txtIdentificador.getText());
    }
}
