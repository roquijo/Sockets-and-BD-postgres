package mvc.graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerInfoPanel extends JPanel implements ActionListener {

    private JLabel jlblNombre;
    private JLabel jlblIdentificacion;
    private JLabel jlblidentificacion;
    private JLabel jlblEdad;
    private JLabel jlblPosicion;

    //private JComboBox jComboBoxPlayer;

    public PlayerInfoPanel(){

        setLayout(new GridLayout(3,3));

        jlblNombre = new JLabel("Nombre");



    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
