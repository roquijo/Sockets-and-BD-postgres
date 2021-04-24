package mvc.graphics.faculty;

import javax.swing.*;
import java.awt.*;

public class ImageOfFaculty extends JPanel{

    private JLabel etiquetaImagen;
    private JLabel blanco1;
    private JLabel blanco2;
    private String ruta;

    public ImageOfFaculty()
    {
        FlowLayout fl = new FlowLayout();
        setLayout(fl);

        ImageIcon imagen = new ImageIcon("src/mvc/images/facultades/facultadCienciasEconomicasYAdministrativas.png");
        etiquetaImagen = new JLabel("" );
        etiquetaImagen.setIcon(imagen);

        blanco1 = new JLabel("                                             ");
        blanco2 = new JLabel("                                             ");

        add(blanco1);
        add(blanco2);
        add(etiquetaImagen);


    }
}
