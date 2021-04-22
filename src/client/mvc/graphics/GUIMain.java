package client.mvc.graphics;

import client.collection.NodeList;
import client.dao.Dao;
import client.dao.FacultyDao;
import client.dto.FacultyDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIMain {
//prueba 2
    public GUIMain() {

        JComboBox comboFacultad = new JComboBox();

        NodeList<FacultyDto> facultyList = new NodeList<>();
        FacultyDao faculty = new FacultyDao();
        FacultyDto facultyDto = new FacultyDto();
        facultyList = faculty.read(facultyDto);
        for (int i = 0; i < facultyList.getSize(); i++) {
            comboFacultad.addItem(facultyList.pop(i).getName());
        }


        comboFacultad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }

    public static void main(String[] args) {
        GUIMain gui = new GUIMain();
        JFrame frame = new JFrame("Torneo Futbol Universidad De Ibagué");
        frame.setContentPane((gui.panelPrincipal));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


    private JPanel panelPrincipal;
    private JPanel panelBanner;
    private JLabel labelBanner;
    private JPanel panelTorneo;
    private JPanel panelOpciones;
    private JButton button6;
    private JButton button7;
    private JPanel panelFacultades;
    private JPanel panelEquipos;
    private JPanel panelJugadores;
    private JPanel panelBotonesFacultades;
    private JButton btnagregarFacultad;
    private JButton btnEliminarFacultad;
    private JButton btnModificarFacultad;
    private JButton btnAgregarEquipo;
    private JButton btnEliminarEquipo;
    private JButton btnModificarEquipo;
    private JPanel panelBotonesJugadores;
    private JPanel panelBotonesEquipo;
    private JButton btnAgregarJugador;
    private JButton btnEliminarJugador;
    private JButton btnModificarJugador;
    private JPanel panelImagenFacultad;
    private JPanel panelInfoFacultad;
    private JLabel labelInfoFacultad;

    private JLabel labelCodigoFacultad;
    private JLabel comboIdFacultad;
    private JTextField txtCodigoFacultad;
    private JTextField txtIdentificadorFacultad;
    private JPanel panelInfoEquipos;
    private JPanel panelImagenEquipo;
    private JLabel labelNombreEquipo;
    private JComboBox comboBox1;
    private JLabel labelCapitanEquipo;
    private JTextField txtCapitan;
    private JLabel labelIdentificador;
    private JTextField txtIdentificadorEquipo;
    private JPanel panelInfoJugadores;
    private JPanel panelImagenJugador;
    private JComboBox comboNombreJugador;
    private JLabel lblNombreJugador;
    private JLabel lblIdentificacion;
    private JTextField txtIdentificacionJugador;
    private JTextField textField2;
    private JLabel lblEdad;
    private JTextField txtEdadJugador;
    private JLabel lblPosicionJugador;
    private JTextField txtPosicionJugador;
    private JLabel lblEquipos;
    private JLabel lblFacultades;
    private JLabel lblImagenJugadores;
    private JLabel lblImagen;
}
